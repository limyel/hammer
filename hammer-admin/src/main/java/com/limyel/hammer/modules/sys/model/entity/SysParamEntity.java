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
@TableName("sys_param_data")
public class SysParamEntity extends BaseEntity {

    /**
     * 参数编码
     */
    private String paramCode;

    /**
     * 参数值
     */
    private String paramValue;

    /**
     * 类型 0: 系统参数，1: 非系统参数
     */
    private Integer paramType;

    /**
     * 备注
     */
    private String remark;

}
