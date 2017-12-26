package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author boge
 * @date 17/12/25
 * @description
 */
@Mapper
public interface UserAddressDao {

    /**
     * 增加用户地址Selective
     *
     * @param userAddress 用户地址信息实体
     * @return
     */
    int insertSelective(UserAddress userAddress);

    /**
     * 通过用户Id查询用户信息
     *
     * @param userId 用户id
     * @return
     */
    List<UserAddress> selectListByUserId(Integer userId);

    /**
     * 通过主键修改用户地址信息
     *
     * @param userAddress 用户地址信息实体
     * @return
     */
    int updateById(UserAddress userAddress);

    /**
     * 通过主键删除用户地址信息
     *
     * @param uaId
     * @return
     */
    int deleteById(Integer uaId);
}
