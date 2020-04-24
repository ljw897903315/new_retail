package cn.jc.new_retail.service;

import cn.jc.new_retail.common.CommonResult;
import cn.jc.new_retail.entity.Delivery;

import java.util.List;

/**
 * @author ljw
 * @date 2020/4/16 15:04
 */
public interface DeliveryService {
    /**
     * 查询配送信息
     * @param pageNum 分页页数
     * @param pageRow 分页显示条数
     * @param region 区域名称
     * @return
     */
    List<Delivery> listDelivery(Integer pageNum, Integer pageRow, String region);

    /**
     *添加配送信息
     * @param delivery
     * @return
     */
    CommonResult insertDelivery(Delivery delivery);

    /**
     * 修改配送信息
     * @param delivery
     * @return
     */
    CommonResult updateDelivery(Delivery delivery);

    /**
     * 删除配送信息
     * @param id 区域编号
     * @return
     */
    CommonResult deleteDelivery(String id);
}
