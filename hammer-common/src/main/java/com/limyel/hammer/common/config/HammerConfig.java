package com.limyel.hammer.common.config;

import com.limyel.hammer.common.token.DoubleToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

/**
 * @author limyel
 */
@Configuration
@EnableConfigurationProperties(HammerProperties.class)
public class HammerConfig {

    private HammerProperties hammerProperties;
    @Autowired
    public void setHammerProperties(HammerProperties hammerProperties) {
        this.hammerProperties = hammerProperties;
    }

    @Bean
    public DoubleToken doubleToken() {
        String secret = hammerProperties.getTokenSecret();
        Integer accessExpire = hammerProperties.getTokenAccessExpire();
        Integer refreshExpire = hammerProperties.getTokenRefreshExpire();
        if (ObjectUtils.isEmpty(accessExpire)) {
            // 默认一小时过期
            accessExpire = 60 * 60;
        }
        if (ObjectUtils.isEmpty(refreshExpire)) {
            // 默认一个月过期
            refreshExpire = 60 * 60 * 24 * 30;
        }
        return new DoubleToken(secret, accessExpire, refreshExpire, hammerProperties.getTokenHeaderName()
                , hammerProperties.getTokenType());
    }

}
