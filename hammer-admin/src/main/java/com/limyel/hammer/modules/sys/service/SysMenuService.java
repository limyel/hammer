package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysMenuEntity;
import com.limyel.hammer.modules.sys.model.request.SysMenuDTO;

/**
 * 菜单
 *
 * @author limyel
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    void add(SysMenuDTO dto);

}
