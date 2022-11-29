package com.limyel.hammer.modules.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.limyel.hammer.modules.oss.model.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 * 
 * @author limyel
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}
