package com.limyel.hammer.modules.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 登录日志
 * 
 * @author limyel
 */
@TableName("sys_log_login")
public class SysLogLoginEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 操作
     */
    private String operation;

    /**
     * 状态，0:成功 1:失败
     */
    private Boolean status;

    /**
     * IP地址
     */
    private String ip;

}
