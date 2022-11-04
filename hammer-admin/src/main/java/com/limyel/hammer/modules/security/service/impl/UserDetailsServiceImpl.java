package com.limyel.hammer.modules.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.modules.security.entity.LoginSysUser;
import com.limyel.hammer.modules.sys.dao.SysUserDao;
import com.limyel.hammer.modules.sys.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        LambdaQueryWrapper<SysUserEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SysUserEntity::getUsername, username);
        Optional<SysUserEntity> optionalSysUser = Optional.ofNullable(sysUserDao.selectOne(queryWrapper));
        SysUserEntity sysUser = optionalSysUser.<HammerException>orElseThrow(() -> {
            throw new HammerException(SysErrorCode.SYS_USER_NOT_FOUND);
        });

        // 封装 UserDetails


        return new LoginSysUser(sysUser);
    }
}
