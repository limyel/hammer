package com.limyel.hammer.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.hammer.modules.sys.dto.SysUserDTO;
import com.limyel.hammer.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *  Mapper 接口
 *
 * @author limyel
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    IPage<SysUserDTO> selectDTOByPage(Page<SysUserDTO> page);

}
