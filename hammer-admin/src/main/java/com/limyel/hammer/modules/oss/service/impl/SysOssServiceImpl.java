package com.limyel.hammer.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.modules.oss.dao.SysOssDao;
import com.limyel.hammer.modules.oss.model.entity.SysOssEntity;
import com.limyel.hammer.modules.oss.service.SysOssService;
import com.limyel.hammer.modules.sys.dao.SysDictDataDao;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.service.SysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文件上传
 *
 * @author limyel
 */
@Service
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Autowired
    private SysOssDao sysOssDao;

    @Override
    public IPage<SysOssEntity> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysOssEntity> page = Page.of(pageNum, pageSize);

        return sysOssDao.selectPage(page, null);
    }

    @Override
    public void add(SysOssEntity sysOssEntity) {
        SysOssEntity sysOss = BeanUtil.copyProperties(sysOssEntity, SysOssEntity.class);

        sysOssDao.insert(sysOss);
    }

    @Override
    public void update(SysOssEntity sysOssEntity) {
        SysOssEntity sysOss  = BeanUtil.copyProperties(sysOssEntity, SysOssEntity.class);

        sysOssDao.updateById(sysOss);
    }

}
