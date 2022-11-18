package com.limyel.hammer.modules.security.controller;

import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.common.token.TokensResult;
import com.limyel.hammer.modules.security.model.request.LoginRequest;
import com.limyel.hammer.modules.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/security")
public class SecurityController {

    @Autowired
    private SecurityService loginService;

    @PostMapping("/login")
    public Result<TokensResult> login(@RequestBody LoginRequest loginRequest) {
        TokensResult tokens = loginService.doLogin(loginRequest);
        return Result.success(tokens);
    }

}
