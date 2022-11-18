package com.limyel.hammer.modules.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色部门关联
 *
 * @author limyel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_dept")
public class SysRoleDeptEntity extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 部门ID
     */
    private Long drptId;

}