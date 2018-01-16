package com.tangmo.shengmei.service;

import com.tangmo.shengmei.entity.AdminInfo;
import com.tangmo.shengmei.entity.GoodsTypeItem;
import com.tangmo.shengmei.utility.code.Result;

/**
 * @author boge
 * @date 18/1/11
 * @description 管理员所需服务控制层
 */

public interface AdminService {

    /**
     * 管理员注册
     *
     * @param adminInfo
     * @return
     */
    Result addAdmin(AdminInfo adminInfo);

    /**
     * 管理员登录
     *
     * @param adminInfo
     * @return
     */
    Result adminLogin(AdminInfo adminInfo);

    /**
     * 增加商品分类
     *
     * @param goodsTypeItem
     * @return
     */
    Result addGoodsTypeItem(GoodsTypeItem goodsTypeItem);

    /**
     * 修改商品分类
     *
     * @param goodsTypeItem
     * @return
     */
    Result changeGoodsTypeItem(GoodsTypeItem goodsTypeItem);

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    Result delGoodsTypeItem(Integer id);
}
