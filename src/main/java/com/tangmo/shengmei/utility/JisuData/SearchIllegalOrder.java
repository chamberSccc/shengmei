package com.tangmo.shengmei.utility.JisuData;

import com.alibaba.fastjson.JSONObject;
import com.tangmo.shengmei.entity.IllegalHandle;
import com.tangmo.shengmei.entity.IllegalInfo;
import com.tangmo.shengmei.utility.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * @author boge
 * @date 18/3/30
 * @description
 */
@Slf4j
public class SearchIllegalOrder {

    public static final String APP_KEY = "da8c4213b24d8dd2";// 你的appkey
    public static final String URL = "http://api.jisuapi.com/illegalhandle/handle";
    public static final String APP_SECRET = "Rec0sHLrg01HJORaZlzvqGvcKPNTM6jJ";

    public static IllegalInfo searchHandleInfo(IllegalHandle handle) throws Exception {
        String url = URL + "?appkey=" + APP_KEY + "&illegalid=" + handle.getIllegalId() + "&mobile="
                + handle.getMobile() + "&sign=" + handle.getMobile()+handle.getIllegalId().replace(",","")
                +handle.getOutOrderNo()+APP_SECRET;
        IllegalInfo illegalInfo = new IllegalInfo();
        String result = null;
        try {
            //第三方接口查询
            result = HttpUtil.sendGet(url);
            if(result.equals("")){
                return null;
            }
            JSONObject json = JSONObject.parseObject(result);
            if (json.getIntValue("status") != 0) {
                return null;
            } else {
                //查询成功,得到违章结果
                JSONObject resultarr = json.getJSONObject("result");
                if (resultarr != null) {
                    handle.setOrderNo(resultarr.getString("orderno"));
                    handle.setCarNo(resultarr.getString("lsprefix") + resultarr.getString("lsnum"));
                    handle.setMobile(resultarr.getString("mobile"));
                    handle.setPayFee(Integer.valueOf(resultarr.getString("totalfee")));
                    handle.setState(resultarr.getString("handlestatus"));
                    handle.setIllegalId(resultarr.getString("illegalid"));
                    handle.setServiceFee(Integer.valueOf(resultarr.getString("servicefee")));
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return illegalInfo;
    }
}
