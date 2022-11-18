package com.limyel.hammer.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.hammer.modules.sys.model.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色菜单关联
 *
 * @author limyel
 */
@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenuEntity> {

}
