package cn.jc.new_retail.test;

import cn.jc.new_retail.util.HttpClientUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import springfox.documentation.spring.web.json.Json;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ljw
 * @date 2020/4/17 10:18
 */
public class AreaSearchTest {

    public static void main(String[] args) {
        String keyName = "零售商城-配送管理";//这里是key名称
        String keyCode = "ac490e48808bf84cdb08bb00dfaf7635";//这个是秘钥
        String admAddress = "https://restapi.amap.com/v3/config/district";
        Map<String, String> params = new HashMap<>();
        params.put("key", keyCode);
        params.put("keywords", "集美区");
        params.put("subdistrict", "0");
        params.put("extensions", "base");
        //获得结果
        String result = HttpClientUtil.doGet(admAddress, params);
        //将结果转为JSONObject
        JSONObject resultJson = JSONObject.fromObject(result);
        //获得districts的内容
        JSONArray districts = resultJson.getJSONArray("districts");
        //获取JSONArray数组里的第一个JSONObject中adcode的值
        Object adcode = districts.getJSONObject(0).get("adcode");
        System.out.println(adcode);


    }
}
