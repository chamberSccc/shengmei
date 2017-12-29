package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.UserShop;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author boge
 * @date 17/12/29
 * @description 用户店铺Dao层
 */
@Mapper
public interface UserShopDao {

    /**
     * 新增用户店铺
     *
     * @param userShop 店铺实体类
     * @return
     */
    int insertSelective(UserShop userShop);

    /**
     * 更改店铺信息
     *
     * @param userShop 店铺实体类
     * @return
     */
    int updateById(UserShop userShop);

    /**
     * 删除店铺信息
     *
     * @param scId 店铺信息主键id
     * @return
     */
    int deleteById(Integer scId);

    /**
     * 查询用户店铺信息
     *
     * @param userId 用户id
     * @return
     */
    UserShop selectByUserId(Integer userId);

    /**
     * 通过用户店铺申请信息
     *
     * @param scId 店铺信息主键id
     * @return
     */
    int updateAuth(Integer scId);
}
