package com.limyel.hammer.common.exception.error;

public enum ErrorCode implements ErrorCodeInterface {
    FAIL(9999, "操作失败"),
    UNKNOWN_ERROR(99999,"未知错误")
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
