package cn.jc.new_retail.controller.backstageController;

import cn.jc.new_retail.common.CommonPage;
import cn.jc.new_retail.common.CommonResult;
import cn.jc.new_retail.entity.Delivery;
import cn.jc.new_retail.entity.Store;
import cn.jc.new_retail.service.DeliveryService;
import cn.jc.new_retail.util.ByAdCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ljw
 * @date 2020/4/16 15:15
 */
@Controller
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/list")
    @ResponseBody
    private CommonResult list(Integer pageNum, Integer pageRow, String region){
        List<Delivery> deliveryList = deliveryService.listDelivery(pageNum, pageRow, region);
        return CommonResult.success(CommonPage.restPage(deliveryList));
    }

    @RequestMapping("/add")
    @ResponseBody
    private CommonResult add(Delivery delivery){
        //调用查找区域编码的接口设置区域编码id
        delivery.setId(ByAdCode.byAdCode(delivery.getRegion()));
        return deliveryService.insertDelivery(delivery);
    }

    @RequestMapping("/edit")
    @ResponseBody
    private CommonResult edit(Delivery delivery){
        return deliveryService.updateDelivery(delivery);
    }

    @RequestMapping("/delete")
    @ResponseBody
    private CommonResult delete(String id){
        return deliveryService.deleteDelivery(id);
    }
}
