package com.result.base;

import com.alibaba.fastjson.JSON;
import com.result.ResultJson;
import com.result.annotation.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：shenjyb
 * @date ：Created in 2021/7/12 17:56
 * @description：
 * @modified By：`
 * @version: 1.0
 */
@RestControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ResponseResult responseResultAnn = returnType.getMethod().getAnnotation(ResponseResult.class);

     /*   HttpServletRequest request = RequestContextHolderUtil.getRequest();
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
       */
        return responseResultAnn != null ;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        ResponseResult responseResultAnn = (ResponseResult) RequestContextHolderUtil.getRequest().getAttribute(ResponseResultInterceptor.RESPONSE_RESULT);
        ResponseResult responseResultAnn = returnType.getMethod().getAnnotation(ResponseResult.class);
        Class<? extends ResultJson> resultClazz = responseResultAnn.value();

        if (resultClazz.isAssignableFrom(ResultJson.class)) {
            if (body instanceof ResultJson) {
                return body;
            }else {
                return JSON.toJSONString(ResultJson.ok(body)) ;
            }
        }
        return body;
    }

}

