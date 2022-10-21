package com.limyel.hammer.modules.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 操作日志
 *
 * @author limyel
 */
@Data
@TableName("sys_log_operation")
public class SysLogOperationEntity extends BaseEntity {

    /**
     * 操作
     */
    private String operation;

    /**
     * 请求URI
     */
    private String requestUri;

    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 执行时间
     */
    private Integer requestTime;

    /**
     * 调用方法
     */
    private String calledMethod;

    /**
     * 状态，0:成功 1:失败
     */
    private Integer status;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 错误消息
     */
    private String errorStack;

}
