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
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        String ip = request.getRemoteAddr();
        String token = request.getHeader("token");
        String user = request.getHeader("userId");
        String url = request.getRequestURI();
        //这里判断管理员的token
        if(url.startsWith("/admin")){
            String admin_token = request.getHeader("admin_token");
            String admin = request.getHeader("admin");
            if(admin_token==null || admin==null){
                return false;
            }
            adminService = (AdminService) factory.getBean("adminService");
            if(adminService.verifyToken(Integer.parseInt(admin),admin_token)){
                return true;
            }else{
                return false;
            }
        }

        //此处判断正常用户请求header逻辑
        if (token == null || user == null) {
            return false;
        }
        Integer userId = Integer.valueOf(user);
        //获取Service实例
        if (userService == null) {
            userService = (UserService) factory.getBean("userService");
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
