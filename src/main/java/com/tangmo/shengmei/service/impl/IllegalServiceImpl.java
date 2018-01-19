package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.IllegalDao;
import com.tangmo.shengmei.dao.UserCarDao;
import com.tangmo.shengmei.entity.IllegalInfo;
import com.tangmo.shengmei.entity.UserCar;
import com.tangmo.shengmei.service.IllegalService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import com.tangmo.shengmei.utility.string.SearchIllegal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Chamber
 * @date 2018/1/17.
 */
@Service("illegalService")
public class IllegalServiceImpl implements IllegalService {
    @Resource
    private IllegalDao illegalDao;
    @Resource
    private UserCarDao userCarDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addIllegalInfo(IllegalInfo illegalInfo) {
        if (illegalInfo.getUserId() == null || illegalInfo.getCarId() == null) {
            return ResultUtil.fail();
        }
        if (illegalInfo.getTotalPrice() == null || illegalInfo.getTotalScore() == null) {
            return ResultUtil.fail();
        }
        illegalDao.insertSelective(illegalInfo);
        return ResultUtil.success();
    }

    @Override
    public Result changeIllegalInfo(IllegalInfo illegalInfo) {
        return null;
    }

    @Override
    public Result getIllegalList(Integer start, Integer end) {
        return ResultUtil.success(illegalDao.selectListInfo(start, end));
    }

    @Override
    public Result getCurrentIllegal(Integer carId) {
        UserCar userCar = userCarDao.selectById(carId);
        IllegalInfo illegalInfo = null;
        try {
            illegalInfo = SearchIllegal.searchScore(userCar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(illegalInfo == null){
            return ResultUtil.fail();
        }
        illegalDao.insertSelective(illegalInfo);
        return ResultUtil.success(illegalInfo);
    }
}
