package com.limyel.hammer.modules.sys.model.entity;

import com.limyel.hammer.common.entity.BaseEntity;
import com.limyel.hammer.modules.security.utils.AuthenticationUtil;

/**
 * @author limyel
 */
public class SysBaseEntity extends BaseEntity {

    public void create() {
        SysUserEntity sysUser = AuthenticationUtil.getSysUser();
        setCreatorId(sysUser.getId());
        setUpdaterId(sysUser.getId());
    }

    public void update() {
        SysUserEntity sysUser = AuthenticationUtil.getSysUser();
        setUpdaterId(sysUser.getId());
    }

}
