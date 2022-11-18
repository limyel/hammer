package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.response.SysUserDTO;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;

import java.util.Set;

/**
 * 系统用户
 *
 * @author limyel
 * @since 2022-10-17
 */
public interface SysUserService extends IService<SysUserEntity> {

    IPage<SysUserDTO> list(Integer pageNum, Integer pageSize);

    SysUserEntity getByUsername(String username);

    Set<String> getMenuPermissionsById(Long sysUserId);
}
