package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.exception.error.ErrorCodeInterface;

public class HammerException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    public HammerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public HammerException(ErrorCodeInterface errorCode) {
        this.code = errorCode.code();
        this.msg = errorCode.msg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
