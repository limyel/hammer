package com.limyel.hammer.modules.sys.model.response;

import lombok.Data;

import java.util.Date;

/**
 * @author limyel
 */
@Data
public class SysMenuResponse {

    private String name;

    private Long parentId;

    private String path;

    private String query;

    private Integer orderNum;

    private String permissions;

    private Integer status;

    private Integer type;

    private String remark;

    private Date createTime;

}
