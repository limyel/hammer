package com.limyel.hammer.common.exception;

import com.limyel.hammer.common.exception.error.ErrorCodeInterface;

/**
 * @author limyel
 */
public enum SysErrorCode implements ErrorCodeInterface {
    // 用户不存在
    SYS_USER_NOT_FOUND(11001, "该系统用户不存在"),
    // 用户登录失败
    SYS_USER_LOGIN_FAILED(11002, "系统用户登录失败"),
    SYS_USER_GET_FAILD(11003, "当前系统用户获取失败"),

    SYS_MENU_SUB_MENU_EXIST(12001, "先删除子菜单或按钮"),

    SYS_PARAM_NOT_FOUND(13001, "系统参数不存在"),
    SYS_PARAM_GET_FAILED(13002, "系统参数获取失败"),

    OSS_UPLOAD_FILE_ERROR(21001, "上传文件失败"),
    OSS_UPLOAD_FILE_EMPTY(21002, "上传文件为空"),
    OSS_SERVICE_NOT_FOUND(21003, "oss服务不存在"),

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
