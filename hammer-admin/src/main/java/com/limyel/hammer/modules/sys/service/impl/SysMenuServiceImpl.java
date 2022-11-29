package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.common.utils.PageUtil;
import com.limyel.hammer.modules.security.utils.AuthenticationUtil;
import com.limyel.hammer.modules.sys.dao.SysMenuDao;
import com.limyel.hammer.modules.sys.model.entity.SysMenuEntity;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.model.request.SysMenuRequest;
import com.limyel.hammer.modules.sys.model.response.SysMenuResponse;
import com.limyel.hammer.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单
 *
 * @author limyel
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public void add(SysMenuRequest sysMenuRequest) {
        SysMenuEntity sysMenu = BeanUtil.copyProperties(sysMenuRequest, SysMenuEntity.class);
        sysMenu.create();
        sysMenuDao.insert(sysMenu);
    }

    @Override
    public List<SysMenuResponse> listSubMenu(Long id) {
        LambdaQueryWrapper<SysMenuEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SysMenuEntity::getParentId, id);
        List<SysMenuEntity> sysMenuList = sysMenuDao.selectList(queryWrapper);
        return BeanUtil.copyToList(sysMenuList, SysMenuResponse.class);
    }

    @Override
    public void update(SysMenuRequest sysMenuRequest) {
        SysMenuEntity sysMenu = BeanUtil.copyProperties(sysMenuRequest, SysMenuEntity.class);
        sysMenu.update();
        sysMenuDao.updateById(sysMenu);
    }

    @Override
    public IPage<SysMenuResponse> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysMenuEntity> page = Page.of(pageNum, pageSize);
        sysMenuDao.selectPage(page, null);
        return PageUtil.copyRecords(page, SysMenuResponse.class);
    }

    @Override
    public SysMenuResponse getById(Long id) {
        SysMenuEntity sysMenu = sysMenuDao.selectById(id);
        SysMenuResponse result = new SysMenuResponse();
        BeanUtils.copyProperties(sysMenu, result);
        return result;
    }
}
