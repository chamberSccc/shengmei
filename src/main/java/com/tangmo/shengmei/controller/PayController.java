package com.tangmo.shengmei.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import com.tangmo.shengmei.entity.Pay;
import com.tangmo.shengmei.entity.PayCallBackBean;
import com.tangmo.shengmei.entity.WeChatPayResultBean;
import com.tangmo.shengmei.service.PayService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.wechat.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    private PayService payService;
	String Key = "C0FB5394A44C380BE3297B69A23A7D3D";
	String appid = "wx7329bea10eb17a5e"; //应用ID 必填：true
	String mch_id = "1495087612";//商户号    必填：true
	String spbill_create_ip="111.230.242.116"; //终端IP 必填：true
	String device_info="WEB";//设备号  必填：false
	String body = "test";//商品描述 必填：true
	String trade_type="APP";//交易类型  必填：true

	int total_fee=1;    //总金额  单位（分） 必填：true

	@GetMapping("/wechat")
	public Result pay(){
		return null;
	}

    @PostMapping("/callback")
    public String callBack(HttpServletRequest request) throws IOException, DocumentException {
        BufferedReader reader = null;

        reader = request.getReader();
        String line = "";
        StringBuffer inputString = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            inputString.append(line);
        }

        SortedMap<String, String> smap = new TreeMap<String, String>();
        Document doc = DocumentHelper.parseText(inputString.toString());
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
            Element e = (Element) iterator.next();
            smap.put(e.getName(), e.getText());
        }
        payService.addPayInfo(smap);
        return returnXML(smap.get("return_code"));
    }

    @GetMapping("/result/{trade_no}")
    public Result getPayResult(@PathVariable String trade_no){
        return payService.selectByTradeNo(trade_no);
    }
    private String returnXML(String return_code) {
        return "<xml><return_code><![CDATA["
                + return_code
                + "]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }
}
