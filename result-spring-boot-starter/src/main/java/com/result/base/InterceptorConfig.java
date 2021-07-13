package com.result.base;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ：shenjyb
 * @date ：Created in 2021/7/12 17:12
 * @description：拦截器配置
 * @modified By：`
 * @version: 1.0
 */

public class InterceptorConfig extends WebMvcConfigurationSupport {


    private ResponseResultInterceptor responseResultInterceptor;

    public InterceptorConfig(ResponseResultInterceptor responseResultInterceptor){
        this.responseResultInterceptor = responseResultInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        String apiUri = "/**";
        //响应结果控制拦截
        registry.addInterceptor(responseResultInterceptor).addPathPatterns(apiUri);
       // registry.addInterceptor(dcmallAccessInterceptor).addPathPatterns("/**/auth/**");
    }
}
