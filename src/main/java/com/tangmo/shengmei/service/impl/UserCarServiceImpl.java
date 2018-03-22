package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.UserCarDao;
import com.tangmo.shengmei.entity.UserCar;
import com.tangmo.shengmei.service.ImgFileService;
import com.tangmo.shengmei.service.UserCarService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    @Resource
    private ImgFileService imgFileService;
    private static final int CAR_NUM_LENGTH = 5;
    private static final int CAR_PROVINCE_LENGTH = 2;
    @Override
    @Transactional
    public Result addUserCar(UserCar userCar) {
        if(userCar.getUserId() ==null || userCar.getCarNum()==null){
            return ResultUtil.fail();
        }

        if(userCar.getCarNum().length() != CAR_NUM_LENGTH && userCar.getCarProvince().length() != CAR_PROVINCE_LENGTH){
            return ResultUtil.fail();
        }
        userCarDao.insertSelective(userCar);
        return ResultUtil.success(userCar);
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

    @Override
    public Result uploadIllegalAttach(Integer carId, MultipartFile file) {
        UserCar usercar = userCarDao.selectById(carId);
        if(usercar == null){
            return ResultUtil.error("信息有误");
        }
        Result result = imgFileService.uploadImg(usercar.getUserId(), file);
        if(result.getCode().equals(Result.SUCCESS)){
            String uuId = result.getData().toString();
            userCarDao.updateIllegalAttach(carId,uuId);
            return ResultUtil.success(uuId);
        }else{
            return result;
        }
    }
}
