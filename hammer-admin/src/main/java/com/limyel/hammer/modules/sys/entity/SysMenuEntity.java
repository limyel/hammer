package com.limyel.hammer.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单
 *
 * @author limyel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父级菜单ID
     */
    private Long parentId;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 路由参数
     */
    private String query;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 权限
     */
    private String permissions;

    /**
     * 状态，0:正常 1:停用
     */
    private Integer status;

    /**
     * 菜单类型，1:目录 2:菜单 3:按钮
     */
    private Integer type;

    /**
     * 备注
     */
    private String remark;

}
