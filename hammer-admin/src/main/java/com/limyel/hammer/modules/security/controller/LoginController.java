package com.limyel.hammer.modules.security.controller;

import com.limyel.hammer.common.api.Result;
import com.limyel.hammer.modules.security.dto.LoginDTO;
import com.limyel.hammer.modules.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result<String> login(@RequestBody LoginDTO loginDTO) {
        String token = loginService.doLogin(loginDTO);
        return Result.success(token);
    }

}
