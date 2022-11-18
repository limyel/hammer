package com.limyel.hammer.modules.sys.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.limyel.hammer.common.validator.group.AddGroup;
import com.limyel.hammer.common.validator.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @NotNull(message = "{id.require}", groups = UpdateGroup.class)
    private Long id;

    /**
     * 用户名
     */
    @NotBlank(message = "{sysuser.password.require}", groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotBlank(message = "{sysuser.password.require}", groups = AddGroup.class)
    private String password;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别
     */
    @Range(min = 0, max = 2, message = "{sysuser.gender.range}", groups = {AddGroup.class, UpdateGroup.class})
    private Integer gender;

    @Email(message = "{sysuser.email.error}", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 部门ID
     */
    @NotNull(message = "{sysuser.deptId.require}", groups = {AddGroup.class, UpdateGroup.class})
    private Long deptId;

    /**
     * 超级管理员
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean superAdmin;

    /**
     * 状态
     */
    @Range(min = 0, max = 1, groups = {AddGroup.class, UpdateGroup.class})
    private Integer status;

    /**
     * 角色ID列表
     */
    private List<Long> roleIdList;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 创建时间
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date createTime;


}
