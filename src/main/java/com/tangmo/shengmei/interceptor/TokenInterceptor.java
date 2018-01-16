package com.tangmo.shengmei.interceptor;

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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        String token = request.getHeader("token");
        Integer userId = Integer.valueOf(request.getHeader("userId"));
        if(token==null || userId == null){
            return false;
        }
        if(userService == null){
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            userService = (UserService) factory.getBean("userService");
        }

        String checkToken = userService.selectToken(userId);
        if(!checkToken.equals(token)){
            return false;
        }
        return true;
    }
}
