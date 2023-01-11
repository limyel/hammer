package com.limyel.hammer.modules.oss.cloud;

import com.limyel.hammer.common.constant.CloudConstant;
import com.limyel.hammer.common.constant.SysParamConstant;
import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.common.utils.BeanUtil;
import com.limyel.hammer.common.utils.SpringUtil;
import com.limyel.hammer.modules.sys.service.SysParamService;

import java.util.Objects;

/**
 * @author limyel
 */
public final class OSSFactory {

    private static SysParamService sysParamService;

    static {
        OSSFactory.sysParamService = SpringUtil.getBean(SysParamService.class);
    }

    public static AbstractCloudStorageService build() {
        CloudStorageConfig config = sysParamService.getValueObject(SysParamConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if (Objects.equals(config.getType(), CloudConstant.QINIU)) {
            return new QiniuCloudStorageService(config);
        } else if (Objects.equals(config.getType(), CloudConstant.ALIYUN)) {
            // todo 阿里云服务
            return new QiniuCloudStorageService(config);
        } else if (Objects.equals(config.getType(), CloudConstant.QCLOUD)) {
            // todo 腾讯云服务
            return new QiniuCloudStorageService(config);
        } else {
            throw new HammerException(SysErrorCode.OSS_SERVICE_NOT_FOUND);
        }
    }

}
