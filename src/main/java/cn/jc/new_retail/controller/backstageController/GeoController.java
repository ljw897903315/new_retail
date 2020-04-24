package cn.jc.new_retail.controller.backstageController;

import cn.jc.new_retail.entity.DTO.StoreDto;
import cn.jc.new_retail.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoLocation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ljw
 * @date 2020/4/22 14:12
 */
@Controller
@RequestMapping("/geo")
public class GeoController {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 基于前端传递的坐标和指定的距离，在门店集合中进行范围查询
     * pos 用户坐标
     * dis 用户指定的距离
     *
     * 返回门店基本信息以及用户距离当前门店的距离
     */
    @GetMapping("/outlets")
    @ResponseBody
    public List<StoreDto> outlets(@RequestParam("pos") String pos, @RequestParam("dis")Double dis){
        //1、基于pos和dis进行范围查找
        //构建距离和中心点对象
        String[] split = pos.split(",");
        Point point = new Point(new Double(split[0]), new Double(split[1]));
        Distance distance = new Distance(dis, Metrics.KILOMETERS);
        Circle circle = new Circle(point,distance);
        //指定返回结果中包含距离信息
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
        args.includeDistance();
        //执行查询
        GeoResults<GeoLocation<String>> results = redisTemplate.boundGeoOps("outlets").radius(circle, args);
        //2、封装返回结果
        List<StoreDto> list = new ArrayList<>();
        for (GeoResult<GeoLocation<String>> result : results) {
            //result 距离信息
             Distance dis2 = result.getDistance();
            String unit = dis2.getUnit();
            if ("km".equals(unit)){
                unit="公里";
            }
            //距离
            String val = new BigDecimal(dis2.getValue()).setScale(2, BigDecimal.ROUND_HALF_UP) + unit;
            //门店基本信息
             GeoLocation<String> location = result.getContent();
             //门店名称
            String name = location.getName();
            //获取门店基本信息
            Store outletsInfo = (Store)redisTemplate.boundHashOps("outletsInfo").get(name);
            //构建StoreDTO对象
            StoreDto storeDto = new StoreDto(outletsInfo, val);
            //放入集合
            list.add(storeDto);
        }
        System.out.println("~~");
        for (StoreDto dto : list) {
            System.out.println(dto.getStore()+dto.getDistance());
        }

        return list;
    }
}
