package com.limyel.hammer.modules.security.service.impl;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.common.token.DoubleToken;
import com.limyel.hammer.common.token.TokensResult;
import com.limyel.hammer.modules.security.model.entity.SecurityUserDetails;
import com.limyel.hammer.modules.security.model.request.LoginRequest;
import com.limyel.hammer.modules.security.service.SecurityService;
import com.limyel.hammer.modules.sys.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DoubleToken doubleToken;

    @Override
    public TokensResult doLogin(LoginRequest loginRequest) {
        // todo 验证码

        // 核验用户名密码
        Authentication authentication = this.checkUsernamePassword(loginRequest);
        SecurityUserDetails userDetails = (SecurityUserDetails) authentication.getPrincipal();

        return doubleToken.generateTokens(userDetails.getUsername());
    }

    private Authentication checkUsernamePassword(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Optional<Authentication> optionalAuthentication = Optional.ofNullable(authenticationManager.authenticate(authenticationToken));
        return optionalAuthentication.<HammerException>orElseThrow(() -> {
            throw new HammerException(SysErrorCode.SYS_USER_LOGIN_FAILED);
        });
    }

}
