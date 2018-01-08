package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户服务接口
 */

public interface UserService {

    /**
     * 增加用户信息
     *
     * @param user 用户对象
     * @return
     */
    Result addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return
     */
    Result changeUser(User user);

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return
     */
    Result getUser(Integer userId);

    /**
     * 用户申请成为商家
     *
     * @param userId 用户id
     * @return
     */
    Result ApplyShopAuth(Integer userId);

    /**
     * 上传头像
     *
     * @param userId
     * @param code
     * @return
     */
    Result uploadAvatar(Integer userId, String code);

    /**
     * 修改手机号
     *
     * @param userId 用户id
     * @param mobile 手机号
     * @return
     */
    Result updateMobile(Integer userId, String mobile);

    /**
     * 验证手机号
     *
     * @param userId
     * @param mobile
     * @return
     */
    Result checkMobile(Integer userId, String mobile);

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    Result changePwd(User user);
}
