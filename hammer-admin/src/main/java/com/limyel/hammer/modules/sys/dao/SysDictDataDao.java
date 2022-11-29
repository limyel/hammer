package com.limyel.hammer.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.model.entity.SysDictTypeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author limyel
 */
@Mapper
public interface SysDictDataDao extends BaseMapper<SysDictDataEntity> {
}
