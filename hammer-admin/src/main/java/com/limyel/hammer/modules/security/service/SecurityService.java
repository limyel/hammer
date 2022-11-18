package com.limyel.hammer.modules.security.service;

import com.limyel.hammer.common.token.TokensResult;
import com.limyel.hammer.modules.security.model.request.LoginRequest;

public interface SecurityService {

    TokensResult doLogin(LoginRequest loginRequest);

}
