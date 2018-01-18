package com.tangmo.shengmei.utility.string;


import com.alibaba.fastjson.JSONObject;
import com.tangmo.shengmei.utility.http.HttpUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author boge
 * @date 18/1/16
 * @description 发送短信
 */

public class SendMsg {

    public static final String APPKEY = "da8c4213b24d8dd2";// 你的appkey
    public static final String REMOTE_URL = "http://api.jisuapi.com/sms/send";
    public static final String mobile = "18710829325";// 手机号
    public static final String content = "您的短信验证码为:123,请不要将验证码告诉他人，如非本人操作，请忽略本短信.【省美科技】";// utf-8

    public static void sendMsg() throws Exception {
        String result = null;
        String url = REMOTE_URL + "?mobile=" + mobile + "&content=" + URLEncoder.encode(content, "utf-8") + "&appkey="
                + APPKEY;

        try {
            result = HttpUtil.sendGet(url);
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

    /**
     * 生成六位随机数
     *
     * @return
     */
    public static String getRandomCode() {
        int number = (int) ((Math.random() * 9 + 1) * 100000);
        return String.valueOf(number);
    }
}
