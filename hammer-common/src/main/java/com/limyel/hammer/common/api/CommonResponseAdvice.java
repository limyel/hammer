package com.limyel.hammer.common.api;

import com.limyel.hammer.common.annotation.CommonResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author limyel
 */
@RestControllerAdvice
public class CommonResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, @NotNull Class converterType) {
        // 对 @CommonResponse 注解对类进行处理
        return returnType.getDeclaringClass().isAnnotationPresent(CommonResponse.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType,
                                  @NotNull Class selectedConverterType, @NotNull ServerHttpRequest request,
                                  @NotNull ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}
