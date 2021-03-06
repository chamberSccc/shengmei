package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.IllegalOrder;
import com.tangmo.shengmei.entity.Pay;
import com.tangmo.shengmei.entity.WeChatPayResultBean;
import com.tangmo.shengmei.utility.code.Result;

import java.util.Map;

/**
 * @author boge
 * @date 18/3/27
 * @description
 */

public interface PayService {

    /**
     * 增加支付信息
     *
     * @param pay
     * @return
     */
    Result addPayInfo(Pay pay);

    /**
     * 增加支付信息
     *
     * @param map
     * @return
     */
    Result addPayInfo(Map<String, String> map);

    /**
     * 查询订单信息
     *
     * @param tradeNo
     * @return
     */
    Result selectByTradeNo(String tradeNo);

    /**
     * 更新微信回调的支付结果
     *
     * @param map
     * @return
     */
    int updatePayResult(Map<String, String> map);

    /**
     * 支付订单
     *
     * @param goId
     * @param userId
     * @return
     */
    Result payOrder(Integer userId, Integer goId);

    /**
     * 支付违章订单预支付
     *
     * @param illegalOrder
     * @return
     */
    Result payIllegalPreOrder(IllegalOrder illegalOrder);

    /**
     * 微信回调成功后支付违章订单
     *
     * @param map
     * @return
     */
    Result payIllegalOrder(Map<String, String> map);


    /**
     * 支付订单时获取预支付信息
     *
     * @param total_fee 总金额
     * @param orderNo   订单号
     * @param url       回调地址
     * @return
     */
    WeChatPayResultBean getWeChatPayInfo(Integer total_fee, String orderNo, String url);
}
