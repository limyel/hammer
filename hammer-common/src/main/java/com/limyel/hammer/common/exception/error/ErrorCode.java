package com.limyel.hammer.common.exception.error;

/**
 * @author limyel
 */

public enum ErrorCode implements ErrorCodeInterface {
    // 失败
    FAIL(90001, "操作失败"),
    UNKNOWN_ERROR(99999,"未知错误"),
    SNOW_FLAKE_DATACENTER_WORKER_ID_ERROR(91101, "datacenterId、workerId 值异常"),
    SNOW_FLAKE_TIMESTAMP_ERROR(91102, "时间戳值异常"),

    JWT_EXPIRED(91201, "JWT 已过期"),
    JWT_TYPE_INVALID(91202, "JWT 类型非法"),
    JWT_SCOPE_INVALID(91203, "JWT scope 非法"),
    JWT_NOT_FOUND(91204, "请传入认证头字段"),
    JWT_RESOLVE_FAILED(91205, "认证头字段解析失败"),
    JWT_ACCESS_TOKEN_EXPIRED(91206, "access token 过期"),
    JWT_ACCESS_TOKEN_ERROR(91207, "access token 异常"),


    ;

    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String msg() {
        return null;
    }
}
