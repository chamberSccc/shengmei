package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.IllegalDao;
import com.tangmo.shengmei.entity.IllegalInfo;
import com.tangmo.shengmei.service.IllegalService;
import com.tangmo.shengmei.utility.code.Result;

import javax.annotation.Resource;

/**
 * @author Chamber
 * @date 2018/1/17.
 */
public class IllegalServiceImpl implements IllegalService {
    @Resource
    private IllegalDao illegalDao;
    @Override
    public Result addIllegalInfo(IllegalInfo illegalInfo) {
        return null;
    }

    @Override
    public Result changeIllegalInfo(IllegalInfo illegalInfo) {
        return null;
    }
}
