package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.UserDao;
import com.tangmo.shengmei.entity.User;
import com.tangmo.shengmei.service.UserService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/20
 * @description 用户接口实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public Result addUser(User user) {
        if (user.getPassword() == null || user.getMobile() == null) {
            return ResultUtil.fail();
        }
        int row = userDao.insertSelective(user);
        if (row == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.fail();
    }
}
