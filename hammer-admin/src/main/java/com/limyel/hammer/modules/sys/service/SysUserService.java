package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;
import com.limyel.hammer.modules.sys.model.request.SysUserRequest;
import com.limyel.hammer.modules.sys.model.response.SysUserResponse;

import java.util.Set;

/**
 * 系统用户
 *
 * @author limyel
 * @since 2022-10-17
 */
public interface SysUserService extends IService<SysUserEntity> {

    IPage<SysUserResponse> list(Integer pageNum, Integer pageSize);

    void add(SysUserRequest sysUserRequest);

    void update(SysUserRequest sysUserRequest);

    SysUserEntity getByUsername(String username);

    Set<String> getMenuPermissionsById(Long sysUserId);
}
