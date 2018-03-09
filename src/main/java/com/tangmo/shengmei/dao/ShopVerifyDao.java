package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.ShopVerify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author boge
 * @date 18/3/9
 * @description
 */

public interface ShopVerifyDao {

    /**
     * 增加商家审核信息
     *
     * @param shopVerify
     * @return
     */
    int insertShopVerify(ShopVerify shopVerify);

    /**
     * 根据用户Id查询
     *
     * @param userId
     * @return
     */
    ShopVerify selectByUserId(Integer userId);

    /**
     * 根据审核状态查询
     *
     * @param state
     * @param start
     * @param end
     * @return
     */
    List<ShopVerify> selectByState(@Param("state") Byte state, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 查询所有的信息
     *
     * @param start
     * @param end
     * @return
     */
    List<ShopVerify> selectAll(@Param("start") Integer start, @Param("end") Integer end);
}
