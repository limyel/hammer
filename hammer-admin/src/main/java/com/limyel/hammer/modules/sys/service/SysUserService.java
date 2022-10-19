package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.dto.SysUserDTO;
import com.limyel.hammer.modules.sys.entity.SysUserEntity;

/**
 * 系统用户
 *
 * @author limyel
 * @since 2022-10-17
 */
public interface SysUserService extends IService<SysUserEntity> {

    IPage<SysUserDTO> list(Integer pageNum, Integer pageSize);

}
