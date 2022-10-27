package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.exception.error.ErrorCodeInterface;

public enum SysErrorCode implements ErrorCodeInterface {
    SYS_USER_NOT_FOUND(11001, "该系统用户不存在")
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
