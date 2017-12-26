package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.UserAddressDao;
import com.tangmo.shengmei.entity.UserAddress;
import com.tangmo.shengmei.service.UserAddressService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/25
 * @description 用户地址服务类
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService{

    @Resource
    private UserAddressDao userAddressDao;
    @Override
    public Result addUserAddress(UserAddress userAddress) {
        if(userAddress.getUserId() == null){
            return ResultUtil.fail();
        }
        userAddressDao.insertSelective(userAddress);
        return ResultUtil.success();
    }

    @Override
    public Result changeUserAddress(UserAddress userAddress) {
        if(userAddress.getUaId() == null){
            return ResultUtil.fail();
        }
        userAddressDao.updateById(userAddress);
        return ResultUtil.success();
    }

    @Override
    public Result searchAddressList(Integer userId) {
        return ResultUtil.success(userAddressDao.selectListByUserId(userId));
    }

    @Override
    public Result delUserAddress(Integer uaId) {
        userAddressDao.deleteById(uaId);
        return ResultUtil.success();
    }
}
