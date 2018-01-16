package com.tangmo.shengmei.utility.string;


import com.alibaba.fastjson.JSONObject;

import java.net.URLEncoder;

/**
 * @author boge
 * @date 18/1/16
 * @description 发送短信
 */

public class SendMsg {

    public static final String APPKEY = "your_appkey_here";// 你的appkey
    public static final String URL = "http://api.jisuapi.com/sms/send";
    public static final String mobile = "18395920855";// 手机号
    public static final String content = "用户您好。【极速数据】";// utf-8

    public static void Get() throws Exception {
        String result = null;
        String url = URL + "?mobile=" + mobile + "&content=" + URLEncoder.encode(content, "utf-8") + "&appkey="
                + APPKEY;

        try {
//            result = HttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.parseObject(result);
            if (json.getIntValue("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.getJSONObject("result");
                String count = resultarr.getString("count");
                String accountid = resultarr.getString("accountid");
                System.out.println(count + " " + accountid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
