package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.UserCarDao;
import com.tangmo.shengmei.entity.UserCar;
import com.tangmo.shengmei.service.UserCarService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/26
 * @description 用户车辆服务实现类
 */
@Service("userCarService")
public class UserCarServiceImpl implements UserCarService {
    @Resource
    private UserCarDao userCarDao;
    private static final int CAR_NUM_LENGEH = 6;
    @Override
    @Transactional
    public Result addUserCar(UserCar userCar) {
        if(userCar.getUserId() ==null || userCar.getCarNum()==null){
            return ResultUtil.fail();
        }

        if(userCar.getCarNum().length() != CAR_NUM_LENGEH){
            return ResultUtil.fail();
        }
        userCarDao.insertSelective(userCar);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result changeUserCar(UserCar userCar) {
        if(userCar.getUcId() == null){
            return ResultUtil.fail();
        }
        userCarDao.updateById(userCar);
        return ResultUtil.success();
    }

    @Override
    public Result searchCarList(Integer userId) {
        return ResultUtil.success(userCarDao.selectListByUserId(userId));
    }

    @Override
    @Transactional
    public Result delUserCar(Integer ucId) {
        userCarDao.deleteById(ucId);
        return ResultUtil.success();
    }
}
