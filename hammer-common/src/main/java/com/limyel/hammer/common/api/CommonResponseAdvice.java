package com.limyel.hammer.common.api;

import com.limyel.hammer.common.annotation.CommonResponse;
import com.limyel.hammer.common.annotation.IgnoreCommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommonResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 对 @CommonResponse 注解对类进行处理，对 @IgnoreCommonResponse 注解对类、方法放行
        return returnType.getDeclaringClass().isAnnotationPresent(CommonResponse.class)
                && !returnType.getDeclaringClass().isAnnotationPresent(IgnoreCommonResponse.class)
                && !returnType.getMethod().isAnnotationPresent(IgnoreCommonResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}
