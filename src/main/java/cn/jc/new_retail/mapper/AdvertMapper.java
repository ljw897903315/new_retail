package cn.jc.new_retail.mapper;

import cn.jc.new_retail.entity.Advert;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author ljw
 * @date 2020/4/8 9:40
 */
@Repository
public interface AdvertMapper {
    /**
     * 轮播图列表
     * @param pageNum 分页页数
     * @param pageRow 分页显示条数
     * @return
     */
    List<Advert> listAdvert(String pageNum, String pageRow);

    /**
     * 添加轮播图
     * @param advert
     * @return
     */
    Boolean saveAdvert(Advert advert);

    /**
     * 修改轮播图
     * @param advert
     * @return
     */
    Boolean updateAdvert(Advert advert);

    /**
     * 删除轮播图
     * @param advert
     * @return
     */
    Boolean removeAdvert(Advert advert);

    /**
     * 排序
     * @param id
     * @param date
     */
    Boolean sortAdvert(@Param("id") String id, @Param("date") Date date);

//    Boolean sortAdvert(String formerId, String laterId, Date formerSortTime, Date laterSortTime);
}
