package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysRoleEntity;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;
import com.limyel.hammer.modules.sys.model.response.SysRoleResponse;

/**
 * 角色
 *
 * @author limyel
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    IPage<SysRoleResponse> listByPage(Integer pageNum, Integer pageSize);

    void add(SysRoleRequest sysRoleRequest);

    void update(SysRoleRequest sysRoleRequest);
}
