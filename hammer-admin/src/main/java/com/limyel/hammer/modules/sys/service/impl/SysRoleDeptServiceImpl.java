package com.limyel.hammer.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.hammer.modules.sys.dao.SysRoleDao;
import com.limyel.hammer.modules.sys.dao.SysRoleDeptDao;
import com.limyel.hammer.modules.sys.dao.SysRoleUserDao;
import com.limyel.hammer.modules.sys.entity.SysRoleDeptEntity;
import com.limyel.hammer.modules.sys.entity.SysRoleUserEntity;
import com.limyel.hammer.modules.sys.service.SysRoleDeptService;
import com.limyel.hammer.modules.sys.service.SysRoleService;
import com.limyel.hammer.modules.sys.service.SysRoleUserService;
import org.springframework.stereotype.Service;

/**
 * 角色部门关联
 *
 * @author limyel
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao, SysRoleDeptEntity> implements SysRoleDeptService {

}
