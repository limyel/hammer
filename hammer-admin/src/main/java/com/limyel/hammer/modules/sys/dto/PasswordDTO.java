package com.limyel.hammer.modules.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class PasswordDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 原密码
     */
    @NotBlank(message = "sysuser.password.require")
    private String password;

    @NotBlank(message = "sysuser.password.require")
    private String newPassword;

}
