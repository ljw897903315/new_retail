package cn.jc.new_retail.service.impl;

import cn.jc.new_retail.common.ResultUtils;
import cn.jc.new_retail.entity.Advert;
import cn.jc.new_retail.mapper.AdvertMapper;
import cn.jc.new_retail.service.AdvertService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ljw
 * @date 2020/4/8 14:00
 */
@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertMapper advertMapper;

    /**
     * 查询全部轮播图
     *
     * @param pageNum 分页页数
     * @param pageRow 分页显示条数
     * @return
     */
    @Override
    public JSONObject listAdvert(String pageNum, String pageRow) {
        List<Advert> advertList = advertMapper.listAdvert(pageNum, pageRow);
        return ResultUtils.sucessResult(advertList);
    }

    /**
     * 添加轮播图
     *
     * @param advert
     * @return
     */
    @Override
    public JSONObject saveAdvert(Advert advert) {
        Boolean aBoolean = advertMapper.saveAdvert(advert);
        return ResultUtils.sucessResult(aBoolean);
    }

    /**
     * 修改轮播图
     *
     * @param advert
     * @return
     */
    @Override
    public JSONObject updateAdvert(Advert advert) {
        Boolean aBoolean = advertMapper.updateAdvert(advert);
        return ResultUtils.sucessResult(aBoolean);
    }

    /**
     * 删除轮播图
     *
     * @param advert
     * @return
     */
    @Override
    public JSONObject removeAdvert(Advert advert) {
        Boolean aBoolean = advertMapper.removeAdvert(advert);
        return ResultUtils.sucessResult(aBoolean);
    }

    /**
     * @param formerId       当前轮播图id
     * @param laterId        要交换轮播图id
     * @param formerSortTime 当前排序时间
     * @param laterSortTime  要交换排序时间
     */
    @Override
    public JSONObject sortAdvert(String formerId, String laterId, Date formerSortTime, Date laterSortTime) {
        Boolean aBoolean1 = advertMapper.sortAdvert(formerId, laterSortTime);
        Boolean aBoolean2 = advertMapper.sortAdvert(laterId, formerSortTime);
        return ResultUtils.sucessResult(aBoolean2);
    }
}
