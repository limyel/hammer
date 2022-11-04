package com.limyel.hammer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门
 *
 * @author limyel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dept")
public class SysDeptEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父级部门ID
     */
    private Long parentId;

    /**
     * 父级部门ID列表，以,分割
     */
    private String parentIds;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 负责人
     */
    private Long leaderId;

    /**
     * 状态，0:正常 1:停用
     */
    private Integer status;

}
