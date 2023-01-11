package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.exception.error.ErrorCode;
import com.limyel.hammer.common.exception.error.ErrorCodeInterface;

/**
 * @author limyel
 */
public class HammerException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int code;

    private final String msg;

    public HammerException() {
        this(ErrorCode.FAIL);
    }

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
