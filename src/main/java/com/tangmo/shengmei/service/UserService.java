package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户服务
 */

public interface UserService {

    /**
     * 增加用户信息
     *
     * @param user
     * @return
     */
    Result addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    Result changeUser(User user);

    /**
     * 获取用户信息
     *
     * @param userId
     * @return
     */
    Result getUser(Integer userId);
}
