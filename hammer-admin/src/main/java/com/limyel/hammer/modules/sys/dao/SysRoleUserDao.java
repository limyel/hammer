package com.limyel.hammer.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.hammer.modules.sys.model.entity.SysRoleUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色用户关联
 *
 * @author limyel
 */
@Mapper
public interface SysRoleUserDao extends BaseMapper<SysRoleUserEntity> {

}
