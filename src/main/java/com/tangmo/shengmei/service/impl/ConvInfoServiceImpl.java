package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ConvInfoDao;
import com.tangmo.shengmei.entity.ConvInfo;
import com.tangmo.shengmei.service.ConvInfoService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/22
 * @description
 */

@Service("convInfoService")
public class ConvInfoServiceImpl implements ConvInfoService {
    @Resource
    private ConvInfoDao convInfoDao;

    @Override
    @Transactional
    public Result addConvInfo(ConvInfo convInfo) {
        if(convInfo.getUserId() == null){
            return ResultUtil.fail();
        }
        convInfoDao.insertSelective(convInfo);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result changeConvInfo(ConvInfo convInfo) {
        return null;
    }
}
