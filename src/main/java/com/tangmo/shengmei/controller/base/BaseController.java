package com.tangmo.shengmei.controller.base;

import com.tangmo.shengmei.service.ConvInfoService;
import com.tangmo.shengmei.service.UserAddressService;
import com.tangmo.shengmei.service.UserService;
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
