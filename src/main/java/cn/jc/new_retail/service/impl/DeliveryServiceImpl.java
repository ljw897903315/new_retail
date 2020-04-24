package cn.jc.new_retail.service.impl;

import cn.jc.new_retail.common.CommonResult;
import cn.jc.new_retail.entity.Delivery;
import cn.jc.new_retail.mapper.DeliveryMapper;
import cn.jc.new_retail.service.DeliveryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ljw
 * @date 2020/4/16 15:05
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryMapper deliveryMapper;

    @Override
    public List<Delivery> listDelivery(Integer pageNum, Integer pageRow, String region) {
        PageHelper.startPage(pageNum, pageRow);
        return deliveryMapper.listDelivery(pageNum, pageRow, region);
    }

    @Override
    public CommonResult insertDelivery(Delivery delivery) {

        int i = deliveryMapper.insertDelivery(delivery);
        if(i>0){
            return CommonResult.success(i);
        }
        return CommonResult.failed();
    }

    @Override
    public CommonResult updateDelivery(Delivery delivery) {
        int i = deliveryMapper.updateDelivery(delivery);
        if(i>0){
            return CommonResult.success(i);
        }
        return CommonResult.failed();
    }

    @Override
    public CommonResult deleteDelivery(String id) {
        int i = deliveryMapper.deleteDelivery(id);
        if(i>0){
            return CommonResult.success(i);
        }
        return CommonResult.failed();
    }
}
