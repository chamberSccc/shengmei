package com.tangmo.shengmei.service.impl;

import com.tangmo.shengmei.dao.UserShopDao;
import com.tangmo.shengmei.entity.UserShop;
import com.tangmo.shengmei.service.UserShopService;
import com.tangmo.shengmei.utility.code.Result;
import com.tangmo.shengmei.utility.code.ResultUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author boge
 * @date 17/12/29
 * @description 用户店铺信息服务类
 */
@Service("userShopService")
public class UserShopServiceImpl implements UserShopService {
    @Resource
    private UserShopDao userShopDao;
    @Override
    @Transactional
    public Result addUserShop(UserShop userShop) {
        if(userShop.getUserId() == null){
            return ResultUtil.fail();
        }
        userShopDao.insertSelective(userShop);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result updateAuth(Integer scId) {
        userShopDao.updateAuth(scId);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result changeUserShop(UserShop userShop) {
        if(userShop.getUsId() == null){
            return ResultUtil.fail();
        }
        userShopDao.updateById(userShop);
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result delUserShop(Integer scId) {
        userShopDao.deleteById(scId);
        return null;
    }

    @Override
    public Result searchUserShop(Integer userId) {
        return ResultUtil.success(userShopDao.selectByUserId(userId));
    }

    @Override
    public Result getGoodsDetail(Integer userId, Integer cdId) {
        return ResultUtil.success();
    }
}
