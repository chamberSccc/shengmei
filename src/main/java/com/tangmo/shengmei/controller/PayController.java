package com.tangmo.shengmei.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

import com.tangmo.shengmei.entity.IllegalOrder;
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

    /**
     * @api {GET} /pay/wechat/order/{userId}/{goId} 微信支付订单
     * @apiGroup Pay
     * @apiVersion 0.0.1
     * @apiParam {int} userId 用户Id
     * @apiParam {int} goId 订单Id
     * @apiDescription 微信支付订单
     * @apiParamExample {json} 请求样例：
     *  /pay/wechat/order/1/15
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     */
    @GetMapping("/wechat/order/{userId}/{goId}")
    public Result payOrder(@PathVariable Integer userId,@PathVariable Integer goId) {
        return payService.payOrder(userId, goId);
    }

    /**
     * @api {POST} /pay/wechat/illegal 微信支付违章订单
     * @apiGroup Pay
     * @apiVersion 0.0.1
     * @apiDescription 微信支付违章订单
     * @apiParamExample {json} 请求样例：
     *               {
     *                   userId:"用户id",
     *                   totalFee:"总费用(单位为分)",
     *                   illegalIds:[1,2,3,4]   违章id illegalId数组
     *               }
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (success) {GET} code success:请求成功； fail:请求失败；offline：掉线；param_error：请求参数错误;
     */
    @PostMapping("/wechat/illegal")
    public Result payIllegalOrder(@RequestBody IllegalOrder illegalOrder){
        return null;
    }

    /**
     * 微信的支付回调接口(订单)
     *
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    @PostMapping("/order/callback")
    public String callBack(HttpServletRequest request){
        Map<String,String> smap = null;
        try {
            smap = getCallBackInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return returnXML(smap.get("return_code"));
        }
        //商品数量-1,通知商家,检查库存是否足够
        payService.updatePayResult(smap);
        return returnXML(smap.get("return_code"));
    }

    @PostMapping("/illegal/callback")
    public String illegalCallBack(HttpServletRequest request){
        Map<String,String> smap = null;
        try {
            smap = getCallBackInfo(request);
        } catch (Exception e) {
            e.printStackTrace();
            return returnXML(smap.get("return_code"));
        }
        payService.updatePayResult(smap);
        //缴费违章代缴
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

    private Map<String,String> getCallBackInfo(HttpServletRequest request) throws DocumentException, IOException {
        BufferedReader reader = null;

        reader = request.getReader();
        String line = "";
        StringBuffer inputString = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            inputString.append(line);
        }
        //微信返回的XML格式解析,用map接收
        SortedMap<String, String> smap = new TreeMap<String, String>();
        Document doc = DocumentHelper.parseText(inputString.toString());
        Element root = doc.getRootElement();
        for (Iterator iterator = root.elementIterator(); iterator.hasNext(); ) {
            Element e = (Element) iterator.next();
            smap.put(e.getName(), e.getText());
        }
        return smap;
    }
}
