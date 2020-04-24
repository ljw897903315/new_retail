package cn.jc.new_retail.controller.backstageController;

import cn.jc.new_retail.common.CommonPage;
import cn.jc.new_retail.common.CommonResult;
import cn.jc.new_retail.entity.Store;
import cn.jc.new_retail.service.StoreService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ljw
 * @date 2020/4/14 14:46
 */
@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;


    @RequestMapping("/list")
    @ResponseBody
    private CommonResult listStore(Integer pageNum, Integer pageRow,String storeName){
        List<Store> storeList = storeService.listStore(pageNum, pageRow, storeName);
        return CommonResult.success(CommonPage.restPage(storeList));
    }

    @RequestMapping("/edit")
    @ResponseBody
    private CommonResult updateStore(Store store){
        Boolean aBoolean = storeService.updateStore(store);
        if(aBoolean=true){
            return CommonResult.success(aBoolean);
        }
        return CommonResult.failed();
    }


    @RequestMapping("/enable")
    @ResponseBody
    private CommonResult enableStore(String storeId,Boolean isEnable){
        Boolean aBoolean = storeService.enableStore(storeId, isEnable);
        if(aBoolean=true){
            return CommonResult.success(aBoolean);
        }
        return CommonResult.failed();
    }


    @RequestMapping("/loadAdmin")
    @ResponseBody
    private CommonResult loadStoreAdmin(String storeId){
        Store store = storeService.loadStoreAdmin(storeId);
        return CommonResult.success(store);

    }


    @RequestMapping("/delete")
    @ResponseBody
    private CommonResult deleteStore(String storeId){
        Boolean aBoolean = storeService.deleteStore(storeId);
        if(aBoolean=true){
            return CommonResult.success(aBoolean);
        }
        return CommonResult.failed();

    }


    @RequestMapping("/add")
    @ResponseBody
    private CommonResult addStore(Store store){
        Boolean aBoolean = storeService.addStore(store);
        if(aBoolean=true){
            return CommonResult.success(aBoolean);
        }
        return CommonResult.failed();

    }








}
