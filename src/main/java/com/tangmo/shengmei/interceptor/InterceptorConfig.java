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
                .excludePathPatterns("/conv/list/**")
                .excludePathPatterns("/conv/comment/list/**")
                .excludePathPatterns("/commodity/select")
                .excludePathPatterns("/file/**")
                .excludePathPatterns("/common/**")
                .excludePathPatterns("/admin/**");
    }
}
