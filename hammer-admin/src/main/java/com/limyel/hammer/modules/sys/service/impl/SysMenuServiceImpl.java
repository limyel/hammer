package com.limyel.hammer.modules.sys.service.impl;

import com.limyel.hammer.modules.security.utils.AuthenticationUtil;
import com.limyel.hammer.modules.sys.dao.SysMenuDao;
import com.limyel.hammer.modules.sys.model.entity.SysMenuEntity;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.model.request.SysMenuDTO;
import com.limyel.hammer.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单
 *
 * @author limyel
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    private SysMenuDao sysMenuDao;
    @Autowired
    public void setSysMenuDao(SysMenuDao sysMenuDao) {
        this.sysMenuDao = sysMenuDao;
    }

    @Override
    public void add(SysMenuDTO dto) {
        SysUserEntity sysUser = AuthenticationUtil.getSysUser();
        SysMenuEntity sysMenu = new SysMenuEntity();
        BeanUtils.copyProperties(dto, sysMenu);
        sysMenu.setCreatorId(sysUser.getId());
        sysMenu.setUpdaterId(sysUser.getId());
        sysMenuDao.insert(sysMenu);
    }
}
