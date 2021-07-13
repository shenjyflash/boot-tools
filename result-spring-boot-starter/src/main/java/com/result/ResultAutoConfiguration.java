package com.result;

import com.result.base.InterceptorConfig;
import com.result.base.ResponseResultHandler;
import com.result.base.ResponseResultInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：shenjyb
 * @date ：Created in 2021/7/12 17:09
 * @description：配置controller返回值包装
 * @modified By：`
 * @version: 1.0
 */
@Configuration
public class ResultAutoConfiguration {

    @Bean
    public ResponseResultInterceptor responseResultInterceptor(){
        return new ResponseResultInterceptor();
    }

    @Bean
    @ConditionalOnBean(ResponseResultInterceptor.class)
    public InterceptorConfig interceptorConfig(ResponseResultInterceptor interceptor ){
        return new InterceptorConfig(interceptor);
    }


    @Bean
    public ResponseResultHandler responseResultHandler( ){
        return new ResponseResultHandler();
    }

}
