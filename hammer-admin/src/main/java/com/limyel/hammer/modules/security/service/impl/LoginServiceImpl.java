package com.limyel.hammer.modules.security.service.impl;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.common.utils.JwtUtil;
import com.limyel.hammer.modules.security.dto.LoginDTO;
import com.limyel.hammer.modules.security.entity.LoginSysUser;
import com.limyel.hammer.modules.security.service.LoginService;
import com.limyel.hammer.modules.sys.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.service.SysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private SysUserService sysUserService;

    @Override
    public String doLogin(LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Optional<Authentication> optionalAuthentication = Optional.ofNullable(authenticationManager.authenticate(authenticationToken));

        Authentication authentication = optionalAuthentication.<HammerException>orElseThrow(() -> {
            throw new HammerException(SysErrorCode.SYS_USER_LOGIN_FAILED);
        });

        LoginSysUser loginSysUser = (LoginSysUser) authentication.getPrincipal();
        SysUserEntity sysUser = sysUserService.getByUsername(loginSysUser.getUsername());
        return jwtUtil.generateToken(sysUser);
    }
}
