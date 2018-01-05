package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ShopGoodsDao;
import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.service.ShopGoodsService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 18/1/2
 * @description 店铺商品信息服务实现类
 */
@Service("shopGoodsService")
public class ShopGoodsServiceImpl implements ShopGoodsService {
    @Resource
    private ShopGoodsDao shopGoodsDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result addShopGoods(ShopGoods shopGoods) {
        if (shopGoods.getUserId() == null) {
            return ResultUtil.fail();
        }
        shopGoodsDao.insertSelective(shopGoods);
        return ResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result changeShopGoods(ShopGoods shopGoods) {
        if (shopGoods.getSgId() == null) {
            return ResultUtil.fail();
        }
        shopGoodsDao.updateById(shopGoods);
        return ResultUtil.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delShopGoods(Integer sgId) {
        shopGoodsDao.deleteById(sgId);
        return ResultUtil.success();
    }

    @Override
    public Result searchShopGoods(Integer usId) {
        return null;
    }

    @Override
    public Result searchQlList(Integer start, Integer end) {
        return ResultUtil.success(shopGoodsDao.selectQlList(start, end));
    }
}
