package com.limyel.hammer.modules.log.service.impl;

import com.limyel.hammer.modules.log.dao.SysLogLoginDao;
import com.limyel.hammer.modules.log.entity.SysLogLoginEntity;
import com.limyel.hammer.modules.log.service.SysLogLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 登录日志
 *
 * @author limyel
 */
@Service
public class SysLogLoginServiceImpl extends ServiceImpl<SysLogLoginDao, SysLogLoginEntity> implements SysLogLoginService {

}
