package com.limyel.hammer.modules.security.service.impl;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.modules.security.model.entity.SecurityUserDetails;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecurityUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        Optional<SysUserEntity> optionalSysUser = Optional.ofNullable(sysUserService.getByUsername(username));
        SysUserEntity sysUser = optionalSysUser.<HammerException>orElseThrow(() -> {
            throw new HammerException(SysErrorCode.SYS_USER_NOT_FOUND);
        });

        // 封装 UserDetails
        Set<String> permissions = sysUserService.getMenuPermissionsById(sysUser.getId());

        return new SecurityUserDetails(sysUser, permissions);
    }
}
