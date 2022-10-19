package com.limyel.hammer.modules.log.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.hammer.modules.log.entity.SysLogLoginEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录日志
 *
 * @author limyel
 */
@Mapper
public interface SysLogLoginDao extends BaseMapper<SysLogLoginEntity> {

}
