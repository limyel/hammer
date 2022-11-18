package com.limyel.hammer.modules.security.service;

import com.limyel.hammer.common.token.TokensResult;
import com.limyel.hammer.modules.security.model.request.LoginRequest;

/**
 * @author limyel
 */
public interface SecurityService {

    /**
     * 处理登录请求
     * @param loginRequest 登录请求参数
     * @return token
     */
    TokensResult doLogin(LoginRequest loginRequest);

}
