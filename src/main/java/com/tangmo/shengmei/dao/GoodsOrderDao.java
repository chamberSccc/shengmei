package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.GoodsOrder;
import com.tangmo.shengmei.entity.GoodsOrderSimple;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 18/3/8
 * @description 商品订单Dao层
 */

public interface GoodsOrderDao {

    /**
     * 增加订单
     *
     * @param goodsOrderSimple
     * @return
     */
    int insertGo(GoodsOrderSimple goodsOrderSimple);

    /**
     * 根据订单状态查询订单
     *
     * @param state
     * @param userId 用户id
     * @param start
     * @param end
     * @return
     */
    List<GoodsOrderSimple> selectOrderByState(@Param("state") Byte state, @Param("userId") Integer userId,
                                              @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 修改订单
     *
     * @param goId
     * @return
     */
    int updateSelective(Integer goId);

    /**
     * 所有用户订单
     *
     * @param userId
     * @param start
     * @param end
     * @return
     */
    List<GoodsOrderSimple> selectAllOrder(@Param("userId") Integer userId, @Param("start") Integer start,
                                          @Param("end") Integer end);

    /**
     * 订单详情
     *
     * @param goId
     * @return
     */
    GoodsOrder selectById(Integer goId);

    /**
     * 修改订单状态
     *
     * @param goId
     * @param state
     * @return
     */
    int updateOrderState(@Param("goId") Integer goId, @Param("state") Byte state);

    /**
     * 修改订单为交易完成
     *
     * @param orderNum
     * @return
     */
    int updateOrderDone(String orderNum);

    /**
     * 删除订单
     *
     * @param goId
     * @return
     */
    int deleteById(Integer goId);

    /**
     * 根据订单编号查询订单信息
     *
     * @param orderNum
     * @return
     */
    GoodsOrder selectByOrderNo(String orderNum);

}
