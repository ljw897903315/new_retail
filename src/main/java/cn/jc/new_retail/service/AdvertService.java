package cn.jc.new_retail.service;

import cn.jc.new_retail.entity.Advert;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @author ljw
 * @date 2020/4/8 11:05
 */
public interface AdvertService {
    /**
     * 轮播图列表
     * @param pageNum 分页页数
     * @param pageRow 分页显示条数
     * @return
     */
    JSONObject listAdvert(String pageNum, String pageRow);

    /**
     * 添加轮播图
     * @param advert
     * @return
     */
    JSONObject saveAdvert(Advert advert);

    /**
     * 修改轮播图
     * @param advert
     * @return
     */
    JSONObject updateAdvert(Advert advert);

    /**
     * 删除轮播图
     * @param advert
     * @return
     */
    JSONObject removeAdvert(Advert advert);

    /**
     * 轮播图排序
     * @param formerId 当前轮播图id
     * @param laterId 要交换轮播图id
     * @param formerSortTime 当前排序时间
     * @param laterSortTime 要交换排序时间
     */
    JSONObject sortAdvert(String formerId, String laterId, Date formerSortTime, Date laterSortTime);
}
