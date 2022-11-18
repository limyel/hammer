package com.limyel.hammer.common.token;

import lombok.Data;

/**
 * @author limyel
 */
@Data
public class TokensResult {

    public TokensResult(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    private String accessToken;

    private String refreshToken;

}
