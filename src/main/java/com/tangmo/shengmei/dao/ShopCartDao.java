package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ShopCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * @param shopCart 购物车实体
     * @return
     */
    int insertSelective(ShopCart shopCart);

    /**
     * 删除指定购物车信息
     *
     * @param scId 购物车主键
     * @return
     */
    int deleteById(Integer scId);

    /**
     * 返回用户下的购物车信息
     *
     * @param userId
     * @paran start 开始索引
     * @paran end 结束索引
     * @return
     */
    List<ShopCart> selectListByUserId(@Param("userId") Integer userId, @Param("start") Integer start, @Param("end") Integer end);
}
