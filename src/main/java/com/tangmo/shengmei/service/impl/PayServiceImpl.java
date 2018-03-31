package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.constant.NotifyUrlConst;
import com.tangmo.shengmei.dao.GoodsOrderDao;
import com.tangmo.shengmei.dao.IllegalHandleDao;
import com.tangmo.shengmei.dao.PayDao;
import com.tangmo.shengmei.dao.UserDao;
import com.tangmo.shengmei.entity.*;
import com.tangmo.shengmei.entity.vo.UserVO;
import com.tangmo.shengmei.service.PayService;
import com.tangmo.shengmei.utility.JisuData.SearchIllegalOrder;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.string.OrderRelated;
import com.tangmo.shengmei.utility.string.SearchIllegal;
import com.tangmo.shengmei.utility.string.StringUtil;
import com.tangmo.shengmei.utility.wechat.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author boge
 * @date 18/3/27
 * @description
 */
@Service("payService")
public class PayServiceImpl implements PayService{
    @Resource
    private PayDao payDao;
    @Resource
    private GoodsOrderDao goodsOrderDao;
    @Resource
    private UserDao userDao;
    @Resource
    private IllegalHandleDao illegalHandleDao;

    String Key = "C0FB5394A44C380BE3297B69A23A7D3D";
    String appid = "wx7329bea10eb17a5e"; //应用ID 必填：true
    String mch_id = "1495087612";//商户号    必填：true
    String spbill_create_ip="111.230.242.116"; //终端IP 必填：true
    String device_info="WEB";//设备号  必填：false
    String body = "shengmei goods";//商品描述 必填：true
    String trade_type="APP";//交易类型  必填：true

    private WeChatPayResultBean weChatPayResultBean;

    @Override
    public Result addPayInfo(Pay pay) {
        payDao.insertPay(pay);
        return ResultUtil.success();
    }

    @Override
    public Result addPayInfo(Map<String, String> map) {
        Pay pay = new Pay();
        pay.setReturn_msg(map.get("return_msg"));
        pay.setResult_code(map.get("result_code"));
        return addPayInfo(pay);
    }

    @Override
    public Result selectByTradeNo(String tradeNo) {
        Pay pay = payDao.selectByTradeNo(tradeNo);
        if(pay == null){
            return ResultUtil.pending();
        }else{
            if (pay.getReturn_msg()!= null){
                return ResultUtil.error(pay.getReturn_msg());
            }else{
                return ResultUtil.success();
            }
        }
    }

    @Override
    @Transactional
    public int updatePayResult(Map<String, String> map) {
        Pay pay = new Pay();
        pay.setReturn_msg(map.get("return_msg"));
        pay.setResult_code(map.get("result_code"));
        pay.setOut_trade_no(map.get("out_trade_no"));
        //更新支付信息
        payDao.updateResultByNo(pay);
        goodsOrderDao.updateOrderDone(pay.getOut_trade_no());
        return 1;
    }

    @Override
    @Transactional
    public Result payOrder(Integer userId,Integer goId) {
        //存储预付信息预付
        GoodsOrder goodsOrder = goodsOrderDao.selectById(goId);
        int fee = (int) (goodsOrder.getPayFee()* 100);
        String orderNo = goodsOrder.getOrderNumber();
        WeChatPayResultBean payResultBean = getWeChatPayInfo(fee,orderNo,NotifyUrlConst.ORDER_URL);
        if(payResultBean == null){
            return ResultUtil.error("微信服务故障");
        }
        payResultBean.setUserId(userId);
        Pay pay = new Pay(payResultBean);
        pay.setPayTarget("商城订单");
        addPayInfo(pay);
        return ResultUtil.success(payResultBean);
    }

    @Override
    public Result payIllegalPreOrder(IllegalOrder illegalOrder) {
        Integer userId = illegalOrder.getUserId();
        String orderNo = OrderRelated.getIllegalOrderNo(illegalOrder.getUserId());
        Integer fee = illegalOrder.getTotalFee();
        WeChatPayResultBean payResultBean = getWeChatPayInfo(fee,orderNo,NotifyUrlConst.ORDER_URL);
        if(payResultBean == null){
            return ResultUtil.error("微信服务故障");
        }
        payResultBean.setUserId(userId);
        Pay pay = new Pay(payResultBean);
        pay.setPayTarget("违章代缴");
        addPayInfo(pay);
        //增加自己的违章代缴信息
        UserVO user = userDao.selectById(pay.getUserId());
        IllegalHandle illegalHandle = new IllegalHandle();
        illegalHandle.setMobile(user.getMobile());
        illegalHandle.setUserId(illegalOrder.getUserId());
        illegalHandle.setOutOrderNo(pay.getOut_trade_no());
        illegalHandle.setIllegalId(StringUtil.converToString(illegalOrder.getIllegalIds()));
        illegalHandleDao.insertIllegalHandle(illegalHandle);
        return ResultUtil.success(payResultBean);
    }

    @Override
    public Result payIllegalOrder(Map<String, String> map) {
        Pay pay = new Pay();
        pay.setReturn_msg(map.get("return_msg"));
        pay.setResult_code(map.get("result_code"));
        pay.setOut_trade_no(map.get("out_trade_no"));
        payDao.updateResultByNo(pay);
        if(pay.getReturn_msg()!= null){
            //提交极速订单
            IllegalHandle illegalHandle = illegalHandleDao.selectByOutTradeNo(pay.getOut_trade_no());
            try {
                SearchIllegalOrder.searchHandleInfo(illegalHandle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //更新代缴信息
            illegalHandleDao.updateByOutTradeNo(illegalHandle);
            //还未处理回调
        }
        return null;
    }


    @Override
    public WeChatPayResultBean getWeChatPayInfo(Integer total_fee,String order_no,String url) {
        String notify_url = url;
        PayCallBackBean payCallBackBean = new PayCallBackBean();
        //生成随机字符串
        String nonce_str = PayUtil.getRandomString(6);
        //订单号
        String out_trade_no = order_no;
        payCallBackBean.setOrdercode(out_trade_no);
        payCallBackBean.setPayway("微信支付");


        SortedMap<Object,Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", appid);
        parameters.put("mch_id", mch_id);
        parameters.put("nonce_str", nonce_str);
        parameters.put("trade_type",trade_type);
        parameters.put("notify_url", notify_url);
        parameters.put("total_fee",total_fee);
        parameters.put("body",body);
        parameters.put("spbill_create_ip", spbill_create_ip);
        parameters.put("out_trade_no", out_trade_no);

        //创建签名
        String sign= Sign.createSign(parameters,Key);

        //创建预支付相关信息
        Pay pay = new Pay();
        pay.setAppid(appid);
        pay.setBody(this.body);
        pay.setMch_id(mch_id);
        pay.setNonce_str(nonce_str);
        pay.setNotify_url(notify_url);
        pay.setOut_trade_no(out_trade_no);
        pay.setSign(sign);
        pay.setSpbill_create_ip(spbill_create_ip);
        pay.setTrade_type(trade_type);
        pay.setTotal_fee(total_fee);

        Xstreamutil.stream.alias("xml", Pay.class);
        String xml=Xstreamutil.stream.toXML(pay).replace("__", "_");
        String requestUrl ="https://api.mch.weixin.qq.com/pay/unifiedorder";
        String requestxml = null;
        String prepay_id = null;
        try {
            requestxml = new HttpsRequest().HttpsRequest(requestUrl,"POST",xml);
            System.out.println(requestxml);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        try {
            Document doc= DocumentHelper.parseText(requestxml);
            Element element_xml=doc.getRootElement();
            List<Element> elementList = element_xml.elements();
            for (int i = 0; i <elementList.size(); i++) {
                System.out.println(elementList.get(i).getName()+" "+elementList.get(i).getText());
                if("prepay_id".equals(elementList.get(i).getName())){
                    prepay_id = elementList.get(i).getTextTrim();

                }

            }
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }

        Long timeStamp = System.currentTimeMillis()/1000;
        //		String Package = "prepay_id="+prepay_id;
        SortedMap<Object, Object> h5parameter = new TreeMap<Object, Object>();
        h5parameter.put("appid", appid);
        h5parameter.put("noncestr", nonce_str);
        h5parameter.put("package","Sign=WXPay");
        h5parameter.put("partnerid",mch_id);
        h5parameter.put("prepayid", prepay_id);
        h5parameter.put("timestamp", timeStamp);

        String Paysign = Sign.createSign(h5parameter, Key);
        weChatPayResultBean = new WeChatPayResultBean();
        weChatPayResultBean.setPartnerId(mch_id);
        weChatPayResultBean.setNonceStr(nonce_str);
        weChatPayResultBean.setPackage2("Sign=WXPay");
        weChatPayResultBean.setPrepayId(prepay_id);
        weChatPayResultBean.setTimeStamp(timeStamp);
        weChatPayResultBean.setSign(Paysign);
        weChatPayResultBean.setTrade_type(trade_type);
        weChatPayResultBean.setOut_trade_no(out_trade_no);
        weChatPayResultBean.setTotal_fee(total_fee);
        return weChatPayResultBean;
    }
}
