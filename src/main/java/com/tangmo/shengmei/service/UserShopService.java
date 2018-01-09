package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.UserShop;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 17/12/29
 * @description 用户店铺服务接口
 */

public interface UserShopService {

    /**
     * 增加用户店铺信息
     *
     * @param userShop 用户店铺实体类
     * @return
     */
    Result addUserShop(UserShop userShop);

    /**
     * 店铺信息授权验证
     *
     * @param scId 用户店铺表主键
     * @return
     */
    Result updateAuth(Integer scId);

    /**
     * 店铺信息修改
     *
     * @param userShop 用户店铺实体类
     * @return
     */
    Result changeUserShop(UserShop userShop);

    /**
     * 删除店铺信息(Admin接口预留)
     *
     * @param scId
     * @return
     */
    Result delUserShop(Integer scId);

    /**
     * 查询用户的店铺信息
     *
     * @param userId
     * @return
     */
    Result searchUserShop(Integer userId);

    /**
     * 得到商品详细信息
     *
     * @param userId
     * @param cdId
     * @return
     */
    Result getGoodsDetail(Integer userId, Integer cdId);
}
