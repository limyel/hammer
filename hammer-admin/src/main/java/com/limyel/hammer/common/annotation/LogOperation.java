package com.limyel.hammer.common.annotation;

import java.lang.annotation.*;

/**
 * @author limyel
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogOperation {

    // 操作
    String value() default "";

}
