package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.model.entity.SysDictTypeEntity;

/**
 * 菜单
 *
 * @author limyel
 */
public interface SysDictDataService extends IService<SysDictDataEntity> {

    IPage<SysDictDataEntity> listByPage(Integer pageNum, Integer pageSize);

    void add(SysDictDataEntity sysDictData);

    void update(SysDictDataEntity sysDictData);
}
