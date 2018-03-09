package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.UserAddressDao;
import com.tangmo.shengmei.entity.UserAddress;
import com.tangmo.shengmei.service.UserAddressService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Result addUserAddress(UserAddress userAddress) {
        if(userAddress.getUserId() == null){
            return ResultUtil.fail();
        }
        userAddressDao.insertSelective(userAddress);
        return ResultUtil.success();
    }

    @Override
    @Transactional
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
    @Transactional
    public Result delUserAddress(Integer uaId) {
        userAddressDao.deleteById(uaId);
        return ResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result changeDefault(Integer uaId) {
        UserAddress userAddress = userAddressDao.selectListById(uaId);
        if(userAddress==null || userAddress.getUserId()==null){
            return ResultUtil.fail();
        }
        userAddressDao.updateUnDefaultByUserId(userAddress.getUserId());
        userAddressDao.updateDefaultById(uaId);
        return ResultUtil.success();
    }

    @Override
    public Result searchDefault(Integer userId) {
        return null;
    }
}
