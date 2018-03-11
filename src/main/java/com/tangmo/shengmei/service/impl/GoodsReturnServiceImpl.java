package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.GoodsReturnDao;
import com.tangmo.shengmei.entity.GoodsReturn;
import com.tangmo.shengmei.service.GoodsReturnService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/3/10
 * @description
 */
@Service("goodsReturnService")
public class GoodsReturnServiceImpl implements GoodsReturnService{
    @Resource
    private GoodsReturnDao goodsReturnDao;
    @Override
    public Result addGoodsReturn(GoodsReturn goodsReturn) {
        goodsReturnDao.insertGoodsReturn(goodsReturn);
        return ResultUtil.success();
    }
}
