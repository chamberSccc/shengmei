package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.Pay;
import com.tangmo.shengmei.entity.WeChatPayResultBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author boge
 * @date 18/3/27
 * @description
 */
@Mapper
public interface PayDao {
    /**
     * 增加预支付信息
     *
     * @param pay
     * @return
     */
    int insertPay(Pay pay);

    /**
     * 查询订单信息
     *
     * @param tradeNo
     * @return
     */
    Pay selectByTradeNo(String tradeNo);

    /**
     * 更新预支付结果
     *
     * @param pay
     * @return
     */
    int updateResultByNo(Pay pay);
}
