package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ConvInfoDao;
import com.tangmo.shengmei.entity.ConvInfo;
import com.tangmo.shengmei.service.ConvInfoService;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.stereotype.Service;

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
    public Result addConvInfo(ConvInfo convInfo) {
        return null;
    }
}
