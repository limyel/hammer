package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.exception.error.ErrorCodeInterface;

public enum SysErrorCode implements ErrorCodeInterface {
    SYS_USER_NOT_FOUND(11001, "该系统用户不存在"),
    SYS_USER_LOGIN_FAILED(11002, "系统用户登录失败"),
    SYS_USER_JWT_EXPIRED(11003, "系统用户 Token 过期")
    ;

    private final int code;
    private final String msg;

    SysErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }
}
