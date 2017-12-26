package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.UserAddress;
import com.tangmo.shengmei.utility.code.Result;

import java.util.List;

/**
 * @author boge
 * @date 17/12/25
 * @description 用户地址服务
 */

public interface UserAddressService {

    /**
     * 增加用户地址信息
     *
     * @param userAddress 地址实体对象
     * @return
     */
    Result addUserAddress(UserAddress userAddress);

    /**
     * 修改用户地址信息
     *
     * @param userAddress 地址实体对象
     * @return
     */
    Result changeUserAddress(UserAddress userAddress);

    /**
     * 获取用户地址信息列表
     *
     * @param userId 用户id
     * @return
     */
    Result searchAddressList(Integer userId);

    /**
     * 删除指定用户地址信息
     *
     * @param uaId
     * @return
     */
    Result delUserAddress(Integer uaId);
}
