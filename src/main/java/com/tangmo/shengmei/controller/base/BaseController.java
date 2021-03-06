package com.tangmo.shengmei.controller.base;

import com.tangmo.shengmei.service.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author boge
 * @date 2017/12/22.
 * @description 基础控制器
 */

public class BaseController {

    @Resource
    protected UserService userService;
    @Resource
    protected ConvInfoService convInfoService;
    @Resource
    protected UserAddressService userAddressService;
    @Resource
    protected UserCarService userCarService;
    @Resource
    protected CommodityService commodityService;
    @Resource
    protected ShopCartService shopCartService;
    @Resource
    protected MyCollectService myCollectService;
    @Resource
    protected UserShopService userShopService;
    @Resource
    protected ShopGoodsService shopGoodsService;
    @Resource
    protected ImgFileService imgFileService;
    @Resource
    protected AdminService adminService;
    @Resource
    protected IllegalService illegalService;
    @Resource
    protected GoodsOrderService goodsOrderService;
    @Resource
    protected CommonService commonService;
    @Resource
    protected ShopVerifyService shopVerifyService;
    @Resource
    protected DeliverRemindService deliverRemindService;
    @Resource
    protected GoodsReturnService goodsReturnService;
    @Resource
    protected CarForumService carForumService;
    /**
     * 得到request对象
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 得到session对象
     */
    protected HttpSession getSession() {
        return this.getRequest().getSession();
    }

    /**
     * 得到requestContext
     */
    protected RequestContext getRequestContext() {
        RequestContext requestContext = new RequestContext(this.getRequest());
        return requestContext;
    }
}
