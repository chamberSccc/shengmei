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


    @GetMapping("/wechat/order/{goId}")
    public Result payOrder(@PathVariable Integer goId) {
        return null;
    }

    /**
     * 微信的支付回调接口
     *
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
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
        for (Iterator iterator = root.elementIterator(); iterator.hasNext(); ) {
            Element e = (Element) iterator.next();
            smap.put(e.getName(), e.getText());
        }
        payService.updatePayResult(smap);
        return returnXML(smap.get("return_code"));
    }

    /**
     * 前台获取预支付信息
     *
     * @param trade_no
     * @return
     */
    @GetMapping("/result/{trade_no}")
    public Result getPayResult(@PathVariable String trade_no) {
        return payService.selectByTradeNo(trade_no);
    }

    /**
     * 微信回调之后,通知微信回调成功XML
     * @param return_code
     * @return
     */
    private String returnXML(String return_code) {
        return "<xml><return_code><![CDATA["
                + return_code
                + "]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
    }
}
