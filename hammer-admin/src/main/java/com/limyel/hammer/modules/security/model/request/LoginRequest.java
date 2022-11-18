package com.limyel.hammer.modules.security.model.request;

import lombok.Data;

/**
 * @author limyel
 */
@Data
public class LoginRequest {

    private String username;

    private String password;

    private String cacheCode;

    private String cache;

}
