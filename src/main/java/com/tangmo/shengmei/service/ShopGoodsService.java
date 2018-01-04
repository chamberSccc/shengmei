package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 18/1/2
 * @description 店铺商品相关操作服务
 */

public interface ShopGoodsService {

    /**
     * 增加店铺商品信息
     *
     * @param shopGoods
     * @return
     */
    Result addShopGoods(ShopGoods shopGoods);

    /**
     * 修改店铺商品信息
     *
     * @param shopGoods
     * @return
     */
    Result changeShopGoods(ShopGoods shopGoods);

    /**
     * 删除指定店铺商品信息
     *
     * @param sgId
     * @return
     */
    Result delShopGoods(Integer sgId);


    /**
     * 查询指定店铺下的商品信息
     *
     * @param usId
     * @return
     */
    Result searchShopGoods(Integer usId);
}
