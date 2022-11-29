package com.limyel.hammer.modules.sys.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author limyel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dict_type")
public class SysDictTypeEntity extends BaseEntity {

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer orderNum;

}
