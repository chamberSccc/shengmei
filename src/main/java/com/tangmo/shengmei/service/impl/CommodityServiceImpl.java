package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.CommodityDao;
import com.tangmo.shengmei.entity.Commodity;
import com.tangmo.shengmei.service.CommodityService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/27
 * @description 商品服务实现类
 */
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityDao commodityDao;

    @Override
    @Transactional
    public Result addCommodity(Commodity commodity) {
        if (commodity.getPriceNow() == null || commodity.getCdType() == null || commodity.getUserId() == null) {
            return ResultUtil.fail();
        }
        commodityDao.insertSelective(commodity);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result changeCommodity(Commodity commodity) {
        if (commodity.getCdId() == null) {
            return ResultUtil.fail();
        }
        commodityDao.updateById(commodity);
        return ResultUtil.success();
    }

    @Override
    public Result searchCdList(Byte cdType, Integer start, Integer end) {
        return ResultUtil.success(commodityDao.selectListByType(cdType, start, end));
    }

    @Override
    public Result searchUserCdList(Integer userId) {
        return ResultUtil.success(commodityDao.selectListByUserId(userId));
    }

    @Override
    @Transactional
    public Result delCommodity(Integer cdId) {
        commodityDao.deleteById(cdId);
        return ResultUtil.success();
    }
}
