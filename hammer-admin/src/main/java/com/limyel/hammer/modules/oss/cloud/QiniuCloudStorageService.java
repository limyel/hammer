package com.limyel.hammer.modules.oss.cloud;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author limyel
 */
public class QiniuCloudStorageService extends AbstractCloudStorageService {

    private UploadManager uploadManager;

    private String token;

    public QiniuCloudStorageService(CloudStorageConfig config){
        this.config = config;

        //初始化
        init();
    }

    private void init() {
        uploadManager = new UploadManager(new Configuration(Region.autoRegion()));
        token = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey())
                .uploadToken(config.getQiniuBucketName());
    }

    @Override
    public String upload(byte[] data, String path) {
        try {
            Response response = uploadManager.put(data, path, token);
            if (!response.isOK()) {
                throw new HammerException(SysErrorCode.OSS_UPLOAD_FILE_ERROR);
            }
        } catch (QiniuException e) {
            throw new HammerException(SysErrorCode.OSS_UPLOAD_FILE_ERROR);
        }
        return config.getQiniuDomain() + "/" + path;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getQiniuPrefix(), suffix));
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return upload(data, path);
        } catch (IOException e) {
            throw new HammerException(SysErrorCode.OSS_UPLOAD_FILE_ERROR);
        }
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getQiniuPrefix(), suffix));
    }
}
