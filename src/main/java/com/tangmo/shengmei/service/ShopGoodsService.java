package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.entity.ShopServiceDto;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 18/1/2
 * @description 店铺商品相关操作服务
 */

public interface ShopGoodsService {

    /**
     * 增加店铺服务信息
     *
     * @param shopGoods
     * @return
     */
    Result addShopService(ShopGoods shopGoods);

    /**
     * 修改店铺服务信息
     *
     * @param shopGoods
     * @return
     */
    Result changeShopService(ShopGoods shopGoods);

    /**
     * 获取商品列表(通过类型)
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    Result searchServiceByType(Byte type, Integer start, Integer end);

    /**
     * 获取服务详情
     *
     * @param sgId
     * @return
     */
    Result searchServiceDetail(Integer sgId);

    /**
     * 筛选服务列表
     *
     * @param shopServiceDto
     * @return
     */
    Result searchByCondition(ShopServiceDto shopServiceDto);

    /**
     * 删除指定店铺商品信息
     *
     * @param sgId
     * @return
     */
    Result delShopGoods(Integer sgId);


    /**
     *
     *
     * @param usId
     * @return
     */
    Result searchShopGoods(Integer usId);
}
