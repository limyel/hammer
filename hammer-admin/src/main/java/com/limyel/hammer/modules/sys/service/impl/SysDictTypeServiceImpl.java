package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.modules.sys.dao.SysDictTypeDao;
import com.limyel.hammer.modules.sys.dao.SysRoleMenuDao;
import com.limyel.hammer.modules.sys.model.entity.SysDictTypeEntity;
import com.limyel.hammer.modules.sys.model.entity.SysRoleMenuEntity;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.model.response.SysUserResponse;
import com.limyel.hammer.modules.sys.service.SysDictTypeService;
import com.limyel.hammer.modules.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据字典类型
 *
 * @author limyel
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeDao, SysDictTypeEntity> implements SysDictTypeService {

    @Autowired
    private SysDictTypeDao sysDictTypeDao;

    @Override
    public IPage<SysDictTypeEntity> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysDictTypeEntity> page = Page.of(pageNum, pageSize);

        return sysDictTypeDao.selectPage(page, null);
    }

    @Override
    public void add(SysDictTypeEntity sysDictTypeEntity) {
        SysDictTypeEntity sysDictType = BeanUtil.copyProperties(sysDictTypeEntity, SysDictTypeEntity.class);

        sysDictTypeDao.insert(sysDictType);
    }

    @Override
    public void update(SysDictTypeEntity sysDictTypeEntity) {
        SysDictTypeEntity sysDictType = BeanUtil.copyProperties(sysDictTypeEntity, SysDictTypeEntity.class);

        sysDictTypeDao.updateById(sysDictType);
    }
}
