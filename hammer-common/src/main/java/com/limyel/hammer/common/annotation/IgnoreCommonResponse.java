package com.limyel.hammer.common.annotation;

import java.lang.annotation.*;

/**
 * @author limyel
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface IgnoreCommonResponse {
}
