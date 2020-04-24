package cn.jc.new_retail.controller.backstageController;

import cn.jc.new_retail.entity.Advert;
import cn.jc.new_retail.service.AdvertService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author ljw
 * @date 2020/4/8 16:31
 */
@Controller
@RequestMapping("/advert")
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @RequestMapping("/list")
    @ResponseBody
    private JSONObject listAdvert(String pageNum, String pageRow){
        return advertService.listAdvert(pageNum,pageRow);
    }

    @RequestMapping("/add")
    @ResponseBody
    private  JSONObject saveAdvert(@RequestBody Advert advert){
        return  advertService.saveAdvert(advert);
    }

    @RequestMapping("/edit")
    @ResponseBody
    private  JSONObject updateAdvert(@RequestBody Advert advert){
        return  advertService.updateAdvert(advert);
    }


    @RequestMapping("/delete")
    @ResponseBody
    private  JSONObject deleteAdvert(@RequestBody Advert advert){
        return  advertService.removeAdvert(advert);
    }

    @RequestMapping("/sort")
    @ResponseBody
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  JSONObject sortAdvert(String formerId, String laterId, Date formerSortTime, Date laterSortTime){
       return advertService.sortAdvert(formerId,laterId,formerSortTime,laterSortTime);
    }
}
