package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.common.utils.PageUtil;
import com.limyel.hammer.modules.sys.dao.SysRoleDao;
import com.limyel.hammer.modules.sys.model.entity.SysMenuEntity;
import com.limyel.hammer.modules.sys.model.entity.SysRoleEntity;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;
import com.limyel.hammer.modules.sys.model.response.SysMenuResponse;
import com.limyel.hammer.modules.sys.model.response.SysRoleResponse;
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
    public IPage<SysRoleResponse> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysRoleEntity> page = Page.of(pageNum, pageSize);
        sysRoleDao.selectPage(page, null);
        return PageUtil.copyRecords(page, SysRoleResponse.class);
    }

    @Override
    public void add(SysRoleRequest sysRoleRequest) {
        SysRoleEntity sysRole = BeanUtil.copyProperties(sysRoleRequest, SysRoleEntity.class);
        sysRoleDao.insert(sysRole);
    }

    @Override
    public void update(SysRoleRequest sysRoleRequest) {
        SysRoleEntity sysRole = BeanUtil.copyProperties(sysRoleRequest, SysRoleEntity.class);
        sysRoleDao.updateById(sysRole);
    }
}
