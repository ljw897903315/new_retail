package cn.jc.new_retail;

import cn.jc.new_retail.entity.Store;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.connection.RedisGeoCommands.GeoLocation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewRetailApplication.class)
class NewRetailApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * geoadd
     * geopos
     * geodist
     * georadius
     * georadiusbymember
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testDelete(){
        redisTemplate.delete("outlets");
    }

    //geoadd 向redis中添加位置信息
    @Test
    public void testGeoAdd(){
        //1、门店位置信息存储
        Point point = new Point(118.04779261350632, 24.610610218240396);
        redisTemplate.boundGeoOps("outlets").add(point,"厦门集美总店");
        //2、门店基本信息存储
        Store store = new Store("厦门集美总店",118.04779261350632,24.610610218240396,"福建省厦门市集美区杏林街道诚毅北大街厦门软件园3期B区","17859764631");
        redisTemplate.boundHashOps("outletsInfo").put("厦门集美总店",store);

    }

    //geopos 返回位置的坐标信息
    @Test
    public  void testGeoPos(){
        List<Point> outlets = redisTemplate.boundGeoOps("outlets").position("厦门集美总店");
        for (Point outlet : outlets) {
            System.out.println("厦门集美总店坐标是：经度"+outlet.getX()+" 纬度"+outlet.getY());
        }
    }

    //批量添加
    @Test
    public void testGeoAddMulti(){
        //outletMap存储的是门店名称和门店的地理位置
        Map<String,Point> outletMap = new HashMap<>();
        //存储门店基本信息
        Store store = new Store(
                "软三分店",
                118.05248111486435, 24.607021053078775,
                "福建省厦门市集美区杏林街道诚毅大街352号软件园3期A区",
                "17859764630"
        );
        //向outletsInfo里面存储门店名称和门店基本信息
        redisTemplate.boundHashOps("outletsInfo").put(store.getStoreName(),store);
        //通过门店的经纬度得到一个point对象
        Point point = new Point(store.getStoreLatitude(),store.getStoreLongitude());
        //门店名称和门店的地理位置存入outletMap
        outletMap.put(store.getStoreName(),point);
        //
        store = new Store("内林分店",118.053341,24.571622,"福建省厦门市集美区杏林街道蓝湾半岛酒店","");
        redisTemplate.boundHashOps("outletsInfo").put(store.getStoreName(),store);
        point = new Point(store.getStoreLatitude(),store.getStoreLongitude());
        outletMap.put(store.getStoreName(),point);
        redisTemplate.boundGeoOps("outlets").add(outletMap);

    }

    //geodist 计算两个位置之间的距离
    @Test
    public void testGeoDist(){
        //以公里显示距离
        Distance distance = redisTemplate.boundGeoOps("outlets").distance("软三分店",
                "内林分店", Metrics.KILOMETERS);
        //获取距离
        double val = distance.getValue();
        //对获取的距离数据进行处理。小数点保留两位，四舍五入
        BigDecimal bigDecimal = new BigDecimal(val).setScale(2, BigDecimal.ROUND_HALF_UP);
        //获取单位
        String unit = distance.getUnit();
        System.out.println("两点相距： "+bigDecimal+unit);

    }


    //georadius 按照给定的经纬度查找指定范围的位置
    @Test
    public void testGeoRadius(){
        //构建中心点和指定距离
        Point point = new Point(118.05248111486435, 24.607021053078775);
        Metric metric;
        Distance distance = new Distance(10, Metrics.KILOMETERS);
        Circle circle = new Circle(point,distance);
        //构建georadiuscommandargs
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
        args.includeDistance();
        //results存放的是查询到的网点位置信息
        GeoResults<GeoLocation<String>> results = redisTemplate.boundGeoOps("outlets").radius(circle, args);
        for (GeoResult<GeoLocation<String>> result : results) {
             GeoLocation<String> location = result.getContent();
            String name = location.getName();
            //获取距离
            Distance dis = result.getDistance();
            String val = new BigDecimal(dis.getValue()).setScale(2, BigDecimal.ROUND_HALF_UP)+dis.getUnit();
            System.out.println("118.05248111486435, 24.607021053078775距离 "+name+val);
        }

    }

    //georadiusbymember 按照给定元素（必须在集合中存在）查找指定范围的位置
    @Test
    public void testGeoRadiusByMember(){
        Distance distance = new Distance(5, Metrics.KILOMETERS);
        RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
        args.includeDistance();
        GeoResults<GeoLocation<String>>  results = redisTemplate.boundGeoOps("outlets").radius("内林分店", distance, args);
        for (GeoResult<GeoLocation<String>> result : results) {
            GeoLocation<String> location = result.getContent();
            String name = location.getName();
            //获取距离
            Distance dis = result.getDistance();
            String val = new BigDecimal(dis.getValue()).setScale(2, BigDecimal.ROUND_HALF_UP)+dis.getUnit();
            System.out.println("内林分店距离 "+name+val);
        }
    }
}
