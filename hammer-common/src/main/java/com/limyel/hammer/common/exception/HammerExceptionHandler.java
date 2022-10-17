package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class HammerExceptionHandler {

    @ExceptionHandler(HammerException.class)
    public Result handleHammerException(HammerException e) {
        return Result.fail(e);
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.fail();
    }
}
