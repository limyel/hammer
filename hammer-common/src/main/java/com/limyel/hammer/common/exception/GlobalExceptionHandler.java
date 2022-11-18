package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.common.utils.ValidationMsgUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author limyel
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HammerException.class)
    public Result<?> handleHammerException(HammerException e) {
        log.error(e.getMsg(), e);
        return Result.fail(e);
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e, HttpServletRequest request) {
        log.error("请求地址'{}'，发生未知异常。", request.getRequestURI(), e);
        return Result.fail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String msg = ValidationMsgUtil.msg(e.getFieldError().getDefaultMessage());
        return Result.failMsg(msg);
    }
}
