package com.tangmo.shengmei.service;

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
     * 获取微信预支付信息
     *
     * @param goId 订单Id
     * @param userId 用户Id
     * @return
     */
    Result getWeChatPayInfo(Integer goId, Integer userId);
}
