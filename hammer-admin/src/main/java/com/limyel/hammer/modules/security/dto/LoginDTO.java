package com.limyel.hammer.modules.security.dto;

import lombok.Data;

@Data
public class LoginDTO {

    private String username;

    private String password;

    private String cacheCode;

    private String cache;

}
