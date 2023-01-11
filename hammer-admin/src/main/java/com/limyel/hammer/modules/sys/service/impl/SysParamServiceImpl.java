package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.modules.sys.dao.SysParamDao;
import com.limyel.hammer.modules.sys.model.entity.SysParamEntity;
import com.limyel.hammer.modules.sys.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * 系统参数
 *
 * @author limyel
 */
@Service
public class SysParamServiceImpl extends ServiceImpl<SysParamDao, SysParamEntity> implements SysParamService {

    @Autowired
    private SysParamDao sysParamDao;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public IPage<SysParamEntity> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysParamEntity> page = Page.of(pageNum, pageSize);

        return sysParamDao.selectPage(page, null);
    }

    @Override
    public void add(SysParamEntity sysParamEntity) {
        SysParamEntity sysParam = BeanUtil.copyProperties(sysParamEntity, SysParamEntity.class);

        sysParamDao.insert(sysParam);
    }

    @Override
    public void update(SysParamEntity sysParamEntity) {
        SysParamEntity sysParam = BeanUtil.copyProperties(sysParamEntity, SysParamEntity.class);

        sysParamDao.updateById(sysParam);
    }

    @Override
    public <T> T getValueObject(String paramCode, Class<T> clazz) {
        String paramValue = getValue(paramCode);
        try {
            return objectMapper.readValue(paramValue, clazz);
        } catch (JsonProcessingException e) {
            throw new HammerException(SysErrorCode.SYS_PARAM_GET_FAILED);
        }
    }

    @Override
    public String getValue(String paramCode) {
        LambdaQueryWrapper<SysParamEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SysParamEntity::getParamCode, paramCode);

        SysParamEntity sysParam = sysParamDao.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(sysParam)) {
            throw new HammerException(SysErrorCode.SYS_PARAM_NOT_FOUND);
        }

        return sysParam.getParamValue();
    }


}
