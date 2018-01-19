package com.tangmo.shengmei.utility.string;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangmo.shengmei.constant.CarOrgCode;
import com.tangmo.shengmei.entity.IllegalDetail;
import com.tangmo.shengmei.entity.IllegalInfo;
import com.tangmo.shengmei.entity.UserCar;
import com.tangmo.shengmei.utility.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author boge
 * @date 18/1/18
 * @description 查询违章信息
 */
@Slf4j
public class SearchIllegal {

    public static final String APP_KEY = "da8c4213b24d8dd2";// 你的appkey
    public static final String URL = "http://api.jisuapi.com/illegal/query";
    public static final String lstype = "02";// 车辆类型
    public static IllegalInfo searchScore(UserCar userCar) throws Exception {
        String lsnum = userCar.getCarNum();
        String lsprefix = userCar.getCarProvince();
        String engineno = userCar.getEngineNum();
        String frameno = userCar.getFrameNum();
        String carorg = CarOrgCode.getCodeByName(lsprefix.substring(0,1));
        String result = null;
        String url = URL + "?appkey=" + APP_KEY + "&carorg=" + carorg + "&lsprefix="
                + URLEncoder.encode(lsprefix, "utf-8") + "&lsnum=" + lsnum + "&lstype=" + lstype + "&frameno="
                + frameno+"&engineno="+engineno;
        IllegalInfo illegalInfo = new IllegalInfo();

        try {
            //第三方接口查询
            result = HttpUtil.sendGet(url);
            JSONObject json = JSONObject.parseObject(result);
            if (json.getIntValue("status") != 0) {
                log.error(json.getString("msg"));
                return null;
            } else {
                //查询成功,得到违章结果
                JSONObject resultarr = json.getJSONObject("result");
                if (resultarr != null) {
                    String totalprice = resultarr.getString("totalprice");
                    String totalscore = resultarr.getString("totalscore");
                    illegalInfo.setTotalPrice(Integer.parseInt(totalprice));
                    illegalInfo.setTotalScore(Integer.parseInt(totalscore));
                    if (resultarr.get("list") != null) {
                        JSONArray list = resultarr.getJSONArray("list");
                        List<IllegalDetail> detailList = new ArrayList<>();
                        //遍历违章细节
                        for (int j = 0; j < list.size(); j++) {
                            JSONObject list_obj = (JSONObject) list.get(j);
                            if (list_obj != null) {
                                IllegalDetail illegalDetail = new IllegalDetail();
                                illegalDetail.setTime(list_obj.getString("time"));
                                illegalDetail.setAddress(list_obj.getString("address"));
                                illegalDetail.setContent(list_obj.getString("content"));
                                illegalDetail.setPrice(list_obj.getString("price"));
                                illegalDetail.setScore(list_obj.getString("score"));
                                illegalDetail.setCanHandle(list_obj.getString("canhandle"));
                                illegalDetail.setHandleFee(list_obj.getString("handlefee"));
                                detailList.add(illegalDetail);
                            }
                        }
                        //违章详细列表放回返回对象中
                        illegalInfo.setCarProvince(userCar.getCarProvince());
                        illegalInfo.setCarNum(userCar.getCarNum());
                        illegalInfo.setIllegalDetails(detailList);
                    }
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
