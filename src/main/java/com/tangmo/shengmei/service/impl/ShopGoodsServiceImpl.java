package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ShopGoodsDao;
import com.tangmo.shengmei.entity.ShopGoods;
import com.tangmo.shengmei.service.ShopGoodsService;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.stereotype.Service;

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
    public Result addShopGoods(ShopGoods shopGoods) {
        return null;
    }

    @Override
    public Result changeShopGoods(ShopGoods shopGoods) {
        return null;
    }

    @Override
    public Result delShopGoods(Integer sgId) {
        return null;
    }

    @Override
    public Result searchShopGoods(Integer usId) {
        return null;
    }
}
