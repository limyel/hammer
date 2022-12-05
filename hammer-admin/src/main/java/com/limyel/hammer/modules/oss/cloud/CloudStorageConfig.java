package com.limyel.hammer.modules.oss.cloud;

import com.limyel.hammer.modules.oss.model.validator.AliyunGroup;
import com.limyel.hammer.modules.oss.model.validator.QcloudGroup;
import com.limyel.hammer.modules.oss.model.validator.QiniuGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CloudStorageConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 类型 1：七牛 2：阿里云 3：腾讯云 4：本地上传 5：MinIO
     */
    @Range(min=1, max=5, message = "{oss.type.range}")
    private Integer type;

    /**
     * 七牛绑定的域名
     */
    @NotBlank(message="{qiniu.domain.require}", groups = QiniuGroup.class)
    @URL(message = "{qiniu.domain.url}", groups = QiniuGroup.class)
    private String qiniuDomain;

    /**
     * 七牛路径前缀
     */
    private String qiniuPrefix;

    /**
     * 七牛ACCESS_KEY
     */
    @NotBlank(message="{qiniu.accesskey.require}", groups = QiniuGroup.class)
    private String qiniuAccessKey;

    /**
     * 七牛SECRET_KEY
     */
    @NotBlank(message="{qiniu.secretkey.require}", groups = QiniuGroup.class)
    private String qiniuSecretKey;

    /**
     * 七牛存储空间名
     */
    @NotBlank(message="{qiniu.bucketname.require}", groups = QiniuGroup.class)
    private String qiniuBucketName;

    /**
     * 阿里云绑定的域名
     */
    @NotBlank(message="{aliyun.domain.require}", groups = AliyunGroup.class)
    @URL(message = "{aliyun.domain.url}", groups = AliyunGroup.class)
    private String aliyunDomain;

    /**
     * 阿里云路径前缀
     */
    private String aliyunPrefix;

    /**
     * 阿里云EndPoint
     */
    @NotBlank(message="{aliyun.endPoint.require}", groups = AliyunGroup.class)
    private String aliyunEndPoint;

    /**
     * 阿里云AccessKeyId
     */
    @NotBlank(message="{aliyun.accesskeyid.require}", groups = AliyunGroup.class)
    private String aliyunAccessKeyId;

    /**
     * 阿里云AccessKeySecret
     */
    @NotBlank(message="{aliyun.accesskeysecret.require}", groups = AliyunGroup.class)
    private String aliyunAccessKeySecret;

    /**
     * 阿里云BucketName
     */
    @NotBlank(message="{aliyun.bucketname.require}", groups = AliyunGroup.class)
    private String aliyunBucketName;

    /**
     * 腾讯云绑定的域名
     */
    @NotBlank(message="{qcloud.domain.require}", groups = QcloudGroup.class)
    @URL(message = "{qcloud.domain.url}", groups = QcloudGroup.class)
    private String qcloudDomain;

    /**
     * 腾讯云路径前缀
     */
    private String qcloudPrefix;

    /**
     * 腾讯云AppId
     */
    @NotNull(message="{qcloud.appid.require}", groups = QcloudGroup.class)
    private Integer qcloudAppId;

    /**
     * 腾讯云SecretId
     */
    @NotBlank(message="{qcloud.secretId.require}", groups = QcloudGroup.class)
    private String qcloudSecretId;

    /**
     * 腾讯云SecretKey
     */
    @NotBlank(message="{qcloud.secretkey.require}", groups = QcloudGroup.class)
    private String qcloudSecretKey;

    /**
     * 腾讯云BucketName
     */
    @NotBlank(message="{qcloud.bucketname.require}", groups = QcloudGroup.class)
    private String qcloudBucketName;

    /**
     * 腾讯云COS所属地区
     */
    @NotBlank(message="{qcloud.region.require}", groups = QcloudGroup.class)
    private String qcloudRegion;


}
