package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.User;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户实体类
 */
public interface UserDao {
    /**
     * 增加用户Selective
     *
     * @param user user对象
     * @return
     */
    int insertSelective(User user);

    /**
     * 通过主键查询用户信息
     *
     * @param id user表主键
     * @return
     */
    User selectByPrimaryKey(Integer id);
}
