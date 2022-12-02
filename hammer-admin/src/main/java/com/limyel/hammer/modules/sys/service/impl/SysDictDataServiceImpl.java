package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.modules.sys.dao.SysDictDataDao;
import com.limyel.hammer.modules.sys.dao.SysDictDataDao;
import com.limyel.hammer.modules.sys.dao.SysRoleMenuDao;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.model.entity.SysRoleMenuEntity;
import com.limyel.hammer.modules.sys.service.SysDictDataService;
import com.limyel.hammer.modules.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据字典数据
 *
 * @author limyel
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataDao, SysDictDataEntity> implements SysDictDataService {

    @Autowired
    private SysDictDataDao sysDictDataDao;

    @Override
    public IPage<SysDictDataEntity> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysDictDataEntity> page = Page.of(pageNum, pageSize);

        return sysDictDataDao.selectPage(page, null);
    }

    @Override
    public void add(SysDictDataEntity SysDictDataEntity) {
        SysDictDataEntity sysDictType = BeanUtil.copyProperties(SysDictDataEntity, SysDictDataEntity.class);

        sysDictDataDao.insert(sysDictType);
    }

    @Override
    public void update(SysDictDataEntity SysDictDataEntity) {
        SysDictDataEntity sysDictType = BeanUtil.copyProperties(SysDictDataEntity, SysDictDataEntity.class);

        sysDictDataDao.updateById(sysDictType);
    }

}
