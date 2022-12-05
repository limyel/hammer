package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.modules.sys.dao.SysParamDao;
import com.limyel.hammer.modules.sys.model.entity.SysParamEntity;
import com.limyel.hammer.modules.sys.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统参数
 *
 * @author limyel
 */
@Service
public class SysParamServiceImpl extends ServiceImpl<SysParamDao, SysParamEntity> implements SysParamService {

    @Autowired
    private SysParamDao sysParamDao;

    @Override
    public IPage<SysParamEntity> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysParamEntity> page = Page.of(pageNum, pageSize);

        return sysParamDao.selectPage(page, null);
    }

    @Override
    public void add(SysParamEntity sysParamEntity) {
        SysParamEntity sysParam = BeanUtil.copyProperties(sysParamEntity, SysParamEntity.class);

        sysParamDao.insert(sysParam);
    }

    @Override
    public void update(SysParamEntity sysParamEntity) {
        SysParamEntity sysParam = BeanUtil.copyProperties(sysParamEntity, SysParamEntity.class);

        sysParamDao.updateById(sysParam);
    }
}
