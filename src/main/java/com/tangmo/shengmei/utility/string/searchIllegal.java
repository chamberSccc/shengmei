package com.tangmo.shengmei.utility.string;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangmo.shengmei.utility.http.HttpUtil;

import java.net.URLEncoder;

/**
 * @author boge
 * @date 18/1/18
 * @description
 */

public class SearchIllegal {

    public static final String APP_KEY = "da8c4213b24d8dd2";// 你的appkey
    public static final String URL = "http://api.jisuapi.com/illegal/query";
    public static final String carorg = "shannxi";// 交管局代号
    public static final String lsprefix = "陕A";// 车牌前缀 utf8
    public static final String lsnum = "L6L71";// 车牌
    public static final String lstype = "02";// 车辆类型
    public static final String engineno = "262036";// 发动机号
    public static final String frameno = "LFV3A23C4E3162272";// 车架号
    public static void searchScore() throws Exception {
        String result = null;
        String url = URL + "?appkey=" + APP_KEY + "&carorg=" + carorg + "&lsprefix="
                + URLEncoder.encode(lsprefix, "utf-8") + "&lsnum=" + lsnum + "&lstype=" + lstype + "&frameno="
                + frameno+"&engineno="+engineno;

        try {
            result = HttpUtil.sendGet(url);
            JSONObject json = JSONObject.parseObject(result);
            if (json.getIntValue("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.getJSONObject("result");
                if (resultarr != null) {
                    String lsprefix = resultarr.getString("lsprefix");
                    String lsnum = resultarr.getString("lsnum");
                    String carorg = resultarr.getString("carorg");
                    String usercarid = resultarr.getString("usercarid");
                    System.out.println(lsprefix + " " + lsnum + " " + carorg + " " + usercarid);
                    if (resultarr.get("list") != null) {
                        JSONArray list = resultarr.getJSONArray("list");
                        for (int j = 0; j < list.size(); j++) {
                            JSONObject list_obj = (JSONObject) list.get(j);
                            if (list_obj != null) {
                                String time = list_obj.getString("time");
                                String address = list_obj.getString("address");
                                String content = list_obj.getString("content");
                                String legalnum = list_obj.getString("legalnum");
                                String price = list_obj.getString("price");
                                String id = list_obj.getString("id");
                                String score = list_obj.getString("score");
                                System.out.println(time + " " + address + " " + content + " " + legalnum + " " + price
                                        + " " + id + " " + score);
                            }
                        }
                    }
                } else {
                    System.out.println("恭喜您，没有违章！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
