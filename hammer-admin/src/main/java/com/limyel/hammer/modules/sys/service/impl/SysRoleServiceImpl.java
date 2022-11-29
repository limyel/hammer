package com.limyel.hammer.modules.sys.service.impl;

import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.modules.sys.dao.SysRoleDao;
import com.limyel.hammer.modules.sys.model.entity.SysRoleEntity;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;
import com.limyel.hammer.modules.sys.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色
 *
 * @author limyel
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public void add(SysRoleRequest sysRoleRequest) {
        SysRoleEntity sysRole = BeanUtil.copyProperties(sysRoleRequest, SysRoleEntity.class);

    }
}
