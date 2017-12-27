package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ShopCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author boge
 * @date 17/12/27
 * @description 购物车Dao接口
 */
@Mapper
public interface ShopCartDao {

    /**
     * 增加购物车信息
     *
     * @param shopCart
     * @return
     */
    int insertSelective(ShopCart shopCart);

    /**
     * 删除指定购物车信息
     *
     * @param scId
     * @return
     */
    int deleteById(Integer scId);

    /**
     * 返回用户下的购物车信息
     *
     * @param userId
     * @return
     */
    List<ShopCart> selectListByUserId(Integer userId);
}
