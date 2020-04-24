package cn.jc.new_retail.mapper;

import cn.jc.new_retail.entity.Delivery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ljw
 * @date 2020/4/16 11:18
 */
@Repository
public interface DeliveryMapper {

    /**
     * 查询配送信息
     * @param pageNum 分页页数
     * @param pageRow 分页显示条数
     * @param region 区域名称
     * @return
     */
    List<Delivery> listDelivery(Integer pageNum,Integer pageRow,String region);

    /**
     *添加配送信息
     * @param delivery
     * @return
     */
    int insertDelivery(Delivery delivery);

    /**
     * 修改配送信息
     * @param delivery
     * @return
     */
    int updateDelivery(Delivery delivery);

    /**
     * 删除配送信息
     * @param id 区域编号
     * @return
     */
    int deleteDelivery(String id);
}
