package com.tangmo.shengmei.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author boge
 * @date 18/1/15
 * @description
 */

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/commodity/list/**")
                .excludePathPatterns("/commodity/comment/list/**")
                .excludePathPatterns("/commodity/quality/**")
                .excludePathPatterns("/commodity/star/**")
                .excludePathPatterns("/commodity/quality/**")
                .excludePathPatterns("/conv/list/**")
                .excludePathPatterns("/conv/comment/list/**")
                .excludePathPatterns("/commodity/select")
                .excludePathPatterns("/file/**")
                .excludePathPatterns("/common/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/mobile/auth/*")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/pwd/reset")
                .excludePathPatterns("/shop/goods/list/**")
                .excludePathPatterns("/list/**")
                .excludePathPatterns("/moments/list/**")
                .excludePathPatterns("/pay/callback");
    }
}
