package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ShopGoods;

import java.util.List;

/**
 * @author boge
 * @date 17/12/29
 * @description 店铺商品Dao接口
 */

public interface ShopGoodsDao {

    /**
     * 增加店铺商品信息
     *
     * @param shopGoods
     * @return
     */
    int insertSelective(ShopGoods shopGoods);

    /**
     * 修改店铺商品信息
     *
     * @param shopGoods
     * @return
     */
    int updateById(ShopGoods shopGoods);

    /**
     * 修改店铺商品信息
     *
     * @param sgId
     * @return
     */
    int deleteById(Integer sgId);

    /**
     * 查询店铺下的所有商品信息
     *
     * @param usId
     * @return
     */
    List<ShopGoods> selectByusId(Integer usId);


}
