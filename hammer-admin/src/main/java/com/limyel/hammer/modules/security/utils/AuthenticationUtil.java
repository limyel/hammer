package com.limyel.hammer.modules.security.utils;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.common.exception.error.ErrorCode;
import com.limyel.hammer.modules.security.model.entity.SecurityUserDetails;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author limyel
 */
public class AuthenticationUtil {

    /**
     * 获取当前登录系统用户
     * @return SysUserEntity
     */
    public static SysUserEntity getSysUser() {
        return getSecurityUserDetails().getSysUser();
    }

    /**
     * 获取当前登录系统用户
     * @return SecurityUserDetails
     */
    public static SecurityUserDetails getSecurityUserDetails() {
        try {
            return (SecurityUserDetails) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new HammerException(SysErrorCode.SYS_USER_GET_FAILD);
        }
    }

    /**
     * 获取 Authentication
     * @return Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
