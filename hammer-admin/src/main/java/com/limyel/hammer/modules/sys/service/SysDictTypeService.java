package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysDictTypeEntity;
import com.limyel.hammer.modules.sys.model.entity.SysMenuEntity;
import com.limyel.hammer.modules.sys.model.request.SysMenuRequest;
import com.limyel.hammer.modules.sys.model.response.SysMenuResponse;

import java.util.List;

/**
 * 菜单
 *
 * @author limyel
 */
public interface SysDictTypeService extends IService<SysDictTypeEntity> {

    IPage<SysDictTypeEntity> listByPage(Integer pageNum, Integer pageSize);

    void add(SysDictTypeEntity sysDictTypeEntity);

    void update(SysDictTypeEntity sysDictTypeEntity);
}
