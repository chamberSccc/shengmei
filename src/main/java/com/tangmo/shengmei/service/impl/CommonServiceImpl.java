package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.CommonDao;
import com.tangmo.shengmei.entity.ParamValue;
import com.tangmo.shengmei.service.CommonService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Chamber
 * @date 2018/3/9.
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
    @Resource
    private CommonDao commonDao;

    @Override
    public Result addParamValue(ParamValue paramValue) {
        if (paramValue.getParamType()==null || paramValue.getParamValue() == null){
            return ResultUtil.paramError();
        }
        commonDao.insertParamValue(paramValue);
        return ResultUtil.success();
    }

    @Override
    public Result searchParamByType(Byte type) {
        return ResultUtil.success(commonDao.selectPvByType(type));
    }

    @Override
    public Result changeParamById(ParamValue paramValue) {
        if(paramValue.getPvId() == null || paramValue.getParamValue() == null){
            return ResultUtil.paramError();
        }
        commonDao.updateParamValue(paramValue);
        return ResultUtil.success();
    }

    @Override
    public Result delParamById(Integer pvId) {
        commonDao.deletePvById(pvId);
        return ResultUtil.success();
    }

    @Override
    public Result searchDistrict(String city) {
        return ResultUtil.success(commonDao.selectDistrict(city));
    }
}
