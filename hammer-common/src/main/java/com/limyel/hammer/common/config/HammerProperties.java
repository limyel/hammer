package com.limyel.hammer.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author limyel
 */
@Data
@ConfigurationProperties("hammer.sys")
public class HammerProperties {

    private String tokenSecret = "123456";

    private Integer tokenAccessExpire = 60 * 60;

    private Integer tokenRefreshExpire = 60 * 60 * 24 * 30;

    private String tokenHeaderName = "Authorization";

    /**
     * 请求头中完整的 token: "{tokenType} {token}"
     */
    private String tokenType = "Bearer";

}
