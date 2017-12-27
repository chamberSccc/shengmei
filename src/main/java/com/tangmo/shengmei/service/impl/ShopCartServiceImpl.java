package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.entity.ShopCart;
import com.tangmo.shengmei.service.ShopCartService;
import com.tangmo.shengmei.utility.code.Result;
import org.springframework.stereotype.Service;

/**
 * @author boge
 * @date 17/12/27
 * @description 购物车服务接口实现类
 */
@Service("shopCartService")
public class ShopCartServiceImpl implements ShopCartService{
    @Override
    public Result addShopCart(ShopCart shopCart) {
        return null;
    }

    @Override
    public Result searchUserCart(Integer userId, Integer start, Integer end) {
        return null;
    }

    @Override
    public Result delCart(Integer scId) {
        return null;
    }
}
