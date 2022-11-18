package com.limyel.hammer.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.hammer.modules.sys.model.response.SysUserDTO;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 *  Mapper 接口
 *
 * @author limyel
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    IPage<SysUserDTO> selectDTOByPage(Page<SysUserDTO> page);

    @Select("SELECT DISTINCT t1.permissions "
            + "FROM sys_menu t1 "
            + " LEFT JOIN sys_role_menu t2 ON t1.id = t2.menu_id "
            + " LEFT JOIN sys_role t3 ON t2.role_id "
            + " LEFT JOIN sys_role_user t4 ON t3.id = t4.role_id "
            + " LEFT JOIN sys_user t5 ON t4.user_id = t5.id AND t5.id = #{userId} "
            + "WHERE t1.status = 0 "
            + " AND t3.status = 0 "
            + " AND t5.status = 0")
    Set<String> selectMenuPermissionsById(Long userId);
}
