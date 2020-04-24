package cn.jc.new_retail.common;

import cn.jc.new_retail.util.enums.ErrorEnum;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ljw
 * @date 2020/4/9 9:26
 */
public class ResultUtils {
    public static JSONObject sucessResult(Object obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",100);
        jsonObject.put("info",obj);
        jsonObject.put("msg","请求成功");
        return jsonObject;
    }
    public static JSONObject sucessResult(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",100);
        jsonObject.put("info",null);
        jsonObject.put("msg","请求成功");
        return jsonObject;
    }
    public static JSONObject errorResult(ErrorEnum obj){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",obj.getErrorCode());
        jsonObject.put("msg",obj.getErrorMsg());
        return jsonObject;
    }
}
