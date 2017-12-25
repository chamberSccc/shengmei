package com.tangmo.shengmei.dao;

import com.tangmo.shengmei.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户信息Dao接口
 */
@Mapper
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
    User selectById(Integer id);

    /**
     * 通过主键修改用户信息
     *
     * @param user
     * @return
     */
    int updateById(User user);
}
