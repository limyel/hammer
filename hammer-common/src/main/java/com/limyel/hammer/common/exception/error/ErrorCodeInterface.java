package com.limyel.hammer.common.exception.error;

/**
 * @author limyel
 */
public interface ErrorCodeInterface {

    /**
     * 返回异常名称
     * @return 异常名称
     */
    String name();

    /**
     * 返回异常代码
     * @return 异常代码
     */
    int code();

    /**
     * 返回异常信息
     * @return 异常信息
     */
    String msg();

}
