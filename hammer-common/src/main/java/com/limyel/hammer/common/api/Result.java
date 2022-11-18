package com.limyel.hammer.common.api;

import com.limyel.hammer.common.exception.HammerException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author limyel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    private final static Integer SUCCESS_CODE = 0;
    private final static String SUCCESS_MSG = "操作成功";
    private final static Integer FAIL_CODE = -1;
    private final static String FAIL_MSG = "操作失败";

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return build(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static <T> Result<T> fail() {
        return build(FAIL_CODE, FAIL_MSG);
    }

    public static <T> Result<T> fail(HammerException hammerException) {
        return fail(hammerException, null);
    }

    public static <T> Result<T> fail(HammerException hammerException, T data) {
        return build(hammerException.getCode(), hammerException.getMsg(), data);
    }

    public static <T> Result<T> fail(T data) {
        return build(FAIL_CODE, FAIL_MSG, data);
    }

    public static <T> Result<T> failMsg(String msg) {
        return build(FAIL_CODE, msg, null);
    }

    public static <T> Result<T> build(Integer code, String msg) {
        return build(code, msg, null);
    }

    public static <T> Result<T> build(Integer code, String msg, T data) {
        return new Result<>(code, msg, data);
    }
}
