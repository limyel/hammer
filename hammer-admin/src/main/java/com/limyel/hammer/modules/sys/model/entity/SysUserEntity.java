package com.limyel.hammer.modules.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户
 * 
 * @author limyel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 性别，0:男 1:女 2:未知
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 超级管理员，0:否 1:是
     */
    private Boolean superAdmin;

    /**
     * 账号状态，0:正常 1:停用
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

}
