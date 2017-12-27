package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ShopCart;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/27
 * @description 购物车服务层
 */

public interface ShopCartService {

    /**
     * 增加购物车信息
     *
     * @param shopCart 购物车实体
     * @return
     */
    Result addShopCart(ShopCart shopCart);

    /**
     * 查找用户购物车信息
     *
     * @param userId 用户Id
     * @param start  开始索引
     * @param end    结束索引
     * @return
     */
    Result searchUserCart(Integer userId, Integer start, Integer end);

    /**
     * 删除指定购物车信息
     *
     * @param scId 购物车表主键
     * @return
     */
    Result delCart(Integer scId);

}
