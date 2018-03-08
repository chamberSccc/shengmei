package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.GoodsOrderSimple;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 18/3/8
 * @description
 */

public interface GoodsOrderService {

    /**
     * 增加订单
     *
     * @param goodsOrderSimple
     * @return
     */
    Result addOrder(GoodsOrderSimple goodsOrderSimple);

    /**
     * 根据条件查询订单
     *
     * @param userId 用户id
     * @param state  订单状态
     * @param start
     * @param end
     * @return
     */
    Result searchOrderByState(Byte state, Integer userId,Integer start,Integer end);

    /**
     * 查询所有用户订单
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    Result searchAllOrder(Integer userId,Integer start,Integer end);

    /**
     * 查询订单详情
     *
     * @param goId
     * @return
     */
    Result searchOrderDetail(Integer goId);

    /**
     * 支付订单
     *
     * @param goId 订单Id
     * @return
     */
    Result payOrder(Integer goId);
}
