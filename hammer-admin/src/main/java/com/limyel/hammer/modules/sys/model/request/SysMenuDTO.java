package com.limyel.hammer.modules.sys.model.request;

import lombok.Data;

/**
 * @author limyel
 */
@Data
public class SysMenuDTO {

    private String name;

    private Long parentId;

    private String path;

    private String query;

    private Integer orderNum;

    private String permissions;

    private Integer status;

    private Integer type;

    private String remark;

}
