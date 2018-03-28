package com.tangmo.shengmei.interceptor;

import com.tangmo.shengmei.service.AdminService;
import com.tangmo.shengmei.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author boge
 * @date 18/1/15
 * @description 检验请求合法性.
 */

public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        String token = request.getHeader("token");
        String user = request.getHeader("userId");
        String admin_token = request.getHeader("admin_token");
        if (token == null || user == null) {
            return false;
        }
        Integer userId = Integer.valueOf(user);
        //获取Service实例
        if (userService == null) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (UserService) factory.getBean("userService");
            adminService = (AdminService) factory.getBean("adminService");
        }
        //增加日活量
        if (ip != null) {
            adminService.addAccessCount(ip);
        }
        String checkToken = userService.selectToken(userId);
        //检查头部请求
        if (!checkToken.equals(token)) {
            return false;
        }
        return true;
    }
}
