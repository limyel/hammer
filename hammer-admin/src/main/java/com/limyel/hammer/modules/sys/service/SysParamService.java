package com.limyel.hammer.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.sys.model.entity.SysParamEntity;

/**
 * 系统参数
 *
 * @author limyel
 */
public interface SysParamService extends IService<SysParamEntity> {

    IPage<SysParamEntity> listByPage(Integer pageNum, Integer pageSize);

    void add(SysParamEntity sysParamEntity);

    void update(SysParamEntity sysParamEntity);
}
