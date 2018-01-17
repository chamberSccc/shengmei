package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.IllegalDao;
import com.tangmo.shengmei.entity.IllegalInfo;
import com.tangmo.shengmei.service.IllegalService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addIllegalInfo(IllegalInfo illegalInfo) {
        if (illegalInfo.getUserId() == null || illegalInfo.getCarId() == null) {
            return ResultUtil.fail();
        }
        if (illegalInfo.getCanHandle() == null || illegalInfo.getHandleFee() == null) {
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
}
