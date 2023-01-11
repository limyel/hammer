package com.limyel.hammer.modules.oss.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.hammer.modules.oss.model.entity.SysOssEntity;
import com.limyel.hammer.modules.sys.model.entity.SysDictDataEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author limyel
 */
public interface SysOssService extends IService<SysOssEntity> {

    IPage<SysOssEntity> listByPage(Integer pageNum, Integer pageSize);

    SysOssEntity add(MultipartFile file);

    void update(SysOssEntity sysOss);

}
