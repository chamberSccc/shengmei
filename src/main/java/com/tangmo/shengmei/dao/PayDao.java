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
    int addPrePay(Pay pay);

    /**
     * 更新支付状态
     *
     * @param prepayId
     * @return
     */
    int updatePayStatus(Integer prepayId);

    /**
     * 失败时更新信息
     *
     * @param prepayId
     * @param msg
     * @return
     */
    int updatePayFailStatus(@Param("prepayId") Integer prepayId,@Param("msg") String msg);
}
