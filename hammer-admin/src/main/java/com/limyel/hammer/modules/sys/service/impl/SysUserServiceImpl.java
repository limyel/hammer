package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.hammer.common.redis.RedisUtil;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.modules.sys.dao.SysUserDao;
import com.limyel.hammer.modules.sys.model.entity.SysRoleEntity;
import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.model.request.SysRoleRequest;
import com.limyel.hammer.modules.sys.model.request.SysUserRequest;
import com.limyel.hammer.modules.sys.model.response.SysUserResponse;
import com.limyel.hammer.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 系统用户
 *
 * @author limyel
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Cacheable(value = "list", keyGenerator = "keyGenerator")
    public IPage<SysUserResponse> listByPage(Integer pageNum, Integer pageSize) {
        Page<SysUserResponse> page = Page.of(pageNum, pageSize);

        return this.sysUserDao.selectByPage(page);
    }

    @Override
    public void add(SysUserRequest sysUserRequest) {
        SysUserEntity sysUser = BeanUtil.copyProperties(sysUserRequest, SysUserEntity.class);

        sysUserDao.insert(sysUser);
    }

    @Override
    public void update(SysUserRequest sysUserRequest) {
        SysUserEntity sysUser = BeanUtil.copyProperties(sysUserRequest, SysUserEntity.class);

        sysUserDao.updateById(sysUser);
    }

    @Override
    public SysUserEntity getByUsername(String username) {
        LambdaQueryWrapper<SysUserEntity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SysUserEntity::getUsername, username);
        
        return sysUserDao.selectOne(queryWrapper);
    }

    @Override
    public Set<String> getMenuPermissionsById(Long sysUserId) {
        Set<String> permissions = sysUserDao.selectMenuPermissionsById(sysUserId);
        return permissions.stream()
                .filter(permission -> !ObjectUtils.isEmpty(permission))
                .map(permission -> permission.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
    }
}
