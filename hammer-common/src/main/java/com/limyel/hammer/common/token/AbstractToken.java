package com.limyel.hammer.common.token;

import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author limyel
 */
@NoArgsConstructor
public abstract class AbstractToken {

    protected String tokenHeaderName;

    protected String tokenType;

    public AbstractToken(String tokenHeaderName, String tokenType) {
        this.tokenHeaderName = tokenHeaderName;
        this.tokenType = tokenType;
    }

    public String getToken(HttpServletRequest request) {
        String header = request.getHeader(this.tokenHeaderName);
        return header.replace(this.tokenType + " ", "");
    }

}
