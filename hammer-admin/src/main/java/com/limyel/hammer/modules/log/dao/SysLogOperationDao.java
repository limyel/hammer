package com.limyel.hammer.modules.log.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.hammer.modules.log.entity.SysLogOperationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作日志
 *
 * @author limyel
 */
@Mapper
public interface SysLogOperationDao extends BaseMapper<SysLogOperationEntity> {

}
