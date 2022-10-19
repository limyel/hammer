package com.limyel.hammer.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.hammer.modules.sys.entity.SysRoleDeptEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色部门关联
 *
 * @author limyel
 */
@Mapper
public interface SysRoleDeptDao extends BaseMapper<SysRoleDeptEntity> {
}