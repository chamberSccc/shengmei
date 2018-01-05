package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ShopGoods;
import org.apache.ibatis.annotations.Param;

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
     * 删除店铺商品信息
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
    List<ShopGoods> selectListByUsId(Integer usId);

    /**
     * 查询精品信息列表
     *
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    List<ShopGoods> selectQlList(@Param("start") Integer start, @Param("end") Integer end);


}
