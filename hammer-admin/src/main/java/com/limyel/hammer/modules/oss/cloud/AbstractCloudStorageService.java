package com.limyel.hammer.modules.oss.cloud;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @author limyel
 */
public abstract class AbstractCloudStorageService {

    /**
     * 云存储配置信息
     */
    protected CloudStorageConfig config;

    /**
     * 文件路径
     * @param prefix    前缀
     * @param suffix    后缀
     * @return          文件路径
     */
    public String getPath(String prefix, String suffix) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String path = DateFormatUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;

        if (StringUtils.hasText(prefix)) {
            path = prefix + "/" + path;
        }

        return path + "." + suffix;
    }

    /**
     * 文件上传
     * @param data      文件字节数组
     * @param path      文件路径，包含文件名
     * @return          返回 http 地址
     */
    public abstract String upload(byte[] data, String path);

    /**
     * 文件上传
     * @param data      文件字节数组
     * @param suffix    后缀
     * @return          返回 http 地址
     */
    public abstract String uploadSuffix(byte[] data, String suffix);

    /**
     * 文件上传
     * @param inputStream       字节流
     * @param path              文件路径，包含文件名
     * @return                  返回 http 地址
     */
    public abstract String upload(InputStream inputStream, String path);

    /**
     * 文件上传
     * @param inputStream       字节流
     * @param suffix            文件路径，包含文件名
     * @return                  返回 http 地址
     */
    public abstract String uploadSuffix(InputStream inputStream, String suffix);

}
