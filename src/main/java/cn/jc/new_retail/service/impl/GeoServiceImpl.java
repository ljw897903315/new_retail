package cn.jc.new_retail.service.impl;

import cn.jc.new_retail.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ljw
 * @date 2020/4/22 15:26
 */
@Service
public class GeoServiceImpl{

    @Autowired
    private RedisTemplate redisTemplate;

    //geoadd 向redis中添加位置信息

    /**
     * 1、门店位置信息 geo
     * 2、门店基本信息 hash
     */
    public void geoAdd(){
        //1、门店位置信息存储
        Point point = new Point(118.04779261350632, 24.610610218240396);
        redisTemplate.boundGeoOps("outlets").add(point,"厦门集美总店");
        //2、门店基本信息存储
        Store store = new Store("厦门集美总店",118.04779261350632,24.610610218240396,"福建省厦门市集美区杏林街道诚毅北大街厦门软件园3期B区","17859764631");
        redisTemplate.boundHashOps("outletsInfo").put("厦门集美总店",store);
    }
}
