package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysMenuEntity;
import com.limyel.hammer.modules.sys.model.request.SysMenuRequest;
import com.limyel.hammer.modules.sys.model.response.SysMenuResponse;

import java.util.List;

/**
 * 菜单
 *
 * @author limyel
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    IPage<SysMenuResponse> listByPage(Integer pageNum, Integer pageSize);

    void add(SysMenuRequest sysMenuRequest);

    List<SysMenuResponse> listSubMenu(Long id);

    void update(SysMenuRequest sysMenuRequest);

    SysMenuResponse getById(Long id);

}
