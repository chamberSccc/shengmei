package com.tangmo.shengmei.utility.string;

import com.alibaba.fastjson.JSONObject;
import com.tangmo.shengmei.entity.LicenseScore;
import com.tangmo.shengmei.utility.http.HttpUtil;

/**
 * @author boge
 * @date 18/1/19
 * @description 驾照查分
 */

public class SearchLicense {

    public static final String APPKEY = "da8c4213b24d8dd2";// 你的appkey
    public static final String URL = "http://api.jisuapi.com/driverlicense/query";

    public static LicenseScore searchLicenseScore(String fileId,String licenseId) {
        String result = null;
        String url = URL + "?appkey=" + APPKEY + "&licensenumber=" + licenseId + "&licenseid=" + fileId;
        LicenseScore licenseScore = null;
        try {
            result = HttpUtil.sendGet(url);
            JSONObject json = JSONObject.parseObject(result);
            if (json.getIntValue("status") != 0) {
                String msg = json.getString("msg");
                LicenseScore licenseScore1 = new LicenseScore();
                licenseScore1.setMsg(msg);
                return licenseScore1;
            } else {
                JSONObject resultarr = json.getJSONObject("result");
                licenseScore = new LicenseScore();
                licenseScore.setValidDate(resultarr.getString("enddate"));
                licenseScore.setFileId(fileId);
                licenseScore.setScore(resultarr.getString("score"));
                licenseScore.setLicenseId(licenseId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return licenseScore;
    }
}
