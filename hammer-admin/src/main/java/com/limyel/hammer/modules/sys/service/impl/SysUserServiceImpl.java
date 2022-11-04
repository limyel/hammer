package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.hammer.modules.sys.dao.SysUserDao;
import com.limyel.hammer.modules.sys.dto.SysUserDTO;
import com.limyel.hammer.modules.sys.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统用户
 *
 * @author limyel
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public IPage<SysUserDTO> list(Integer pageNum, Integer pageSize) {
        Page<SysUserDTO> page = Page.of(pageNum, pageSize);

        return this.sysUserDao.selectDTOByPage(page);
    }

    @Override
    public SysUserEntity getByUsername(String username) {
        LambdaQueryWrapper<SysUserEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SysUserEntity::getUsername, username);
        
        return sysUserDao.selectOne(queryWrapper);
    }
}
