package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.exception.error.ErrorCodeInterface;

public enum SysErrorCode implements ErrorCodeInterface {
    ;

    private final int code;
    private final String msg;

    SysErrorCode(int code, String msg) {
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
