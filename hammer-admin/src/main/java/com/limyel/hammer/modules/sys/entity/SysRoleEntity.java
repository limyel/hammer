package com.limyel.hammer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色
 * 
 * @author limyel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class SysRoleEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 状态，0:正常 1:停用
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

}
