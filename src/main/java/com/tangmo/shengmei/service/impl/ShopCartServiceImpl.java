package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.ShopCartDao;
import com.tangmo.shengmei.entity.ShopCart;
import com.tangmo.shengmei.service.ShopCartService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/27
 * @description 购物车服务接口实现类
 */
@Service("shopCartService")
public class ShopCartServiceImpl implements ShopCartService{

    @Resource
    private ShopCartDao shopCartDao;
    @Override
    @Transactional
    public Result addShopCart(ShopCart shopCart) {

        try {
            shopCartDao.insertSelective(shopCart);
        } catch (Exception e) {
            return ResultUtil.fail();
        }
        return ResultUtil.success();
    }

    @Override
    public Result searchUserCart(Integer userId, Integer start, Integer end) {
        return ResultUtil.success(shopCartDao.selectListByUserId(userId,start,end));
    }

    @Override
    @Transactional
    public Result delCart(Integer scId) {
        shopCartDao.deleteById(scId);
        return ResultUtil.success();
    }
}
