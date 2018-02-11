package com.tangmo.shengmei.controller;

import java.util.Date;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.tangmo.shengmei.entity.Pay;
import com.tangmo.shengmei.entity.PayCallBackBean;
import com.tangmo.shengmei.entity.WeChatPayResultBean;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.wechat.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PayController {

	String Key = "C0FB5394A44C380BE3297B69A23A7D3D";
	String appid = "wx7329bea10eb17a5e"; //应用ID 必填：true
	String mch_id = "1495087612";//商户号    必填：true
	String spbill_create_ip="111.230.242.116"; //终端IP 必填：true
	String device_info="WEB";//设备号  必填：false
	String body = "test";//商品描述 必填：true
	String trade_type="APP";//交易类型  必填：true

	//	int total_fee=888;    //总金额  单位（分） 必填：true
	private WeChatPayResultBean weChatPayResultBean;

	@GetMapping("/wechat")
	public Result pay(@RequestParam Integer total_fee, @RequestParam Integer userid){
		String userId = userid.toString();
		String notify_url ="http://www.weixin.qq.com/wxpay/pay.php";
		PayCallBackBean payCallBackBean = new PayCallBackBean();
		//生成随机字符串
		String nonce_str = PayUtil.getRandomString(6);
		//订单号
		String out_trade_no = DateUtil.DateToString(new Date(),"yyyyMMddHHmmssSSS");
		//订单编号
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

		String sign=Sign.createSign(parameters,Key);

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
			return ResultUtil.fail();
		}

		try {
			Document doc=DocumentHelper.parseText(requestxml);
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
			return ResultUtil.fail();
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
		/*		request.setAttribute("appid", appid);
		request.setAttribute("nonce_str",nonce_str);
		request.setAttribute("Package", Package);
		request.setAttribute("timeStamp", timeStamp);
		request.setAttribute("paySign", Paysign);
		request.setAttribute("ordersId", "123456");*/
		System.out.println(notify_url);
		return ResultUtil.success(weChatPayResultBean);
	}
}
