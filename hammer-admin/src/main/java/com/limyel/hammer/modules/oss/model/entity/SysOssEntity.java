package com.limyel.hammer.modules.oss.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.hammer.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author limyel
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_oss")
public class SysOssEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * URL地址
     */
    private String url;

}
