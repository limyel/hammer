package com.limyel.hammer.common.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@RestController
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CommonResponse {
}
