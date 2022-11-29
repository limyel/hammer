package com.limyel.hammer.modules.oss.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.limyel.hammer.modules.oss.dao.SysOssDao;
import com.limyel.hammer.modules.oss.model.entity.SysOssEntity;
import com.limyel.hammer.modules.oss.service.SysOssService;
import com.limyel.hammer.modules.sys.dao.SysDictDataDao;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import com.limyel.hammer.modules.sys.service.SysDictDataService;
import org.springframework.stereotype.Service;

/**
 * 文件上传
 *
 * @author limyel
 */
@Service
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

}
