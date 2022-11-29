package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysRoleEntity;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;

/**
 * 角色
 *
 * @author limyel
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    void add(SysRoleRequest sysRoleRequest);

}
