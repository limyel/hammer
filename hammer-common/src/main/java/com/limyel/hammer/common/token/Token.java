package com.limyel.hammer.common.token;

import com.auth0.jwt.interfaces.Claim;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@NoArgsConstructor
public abstract class Token {

    protected String tokenHeaderName;

    protected String tokenType;

    public Token(String tokenHeaderName, String tokenType) {
        this.tokenHeaderName = tokenHeaderName;
        this.tokenType = tokenType;
    }

    public String getToken(HttpServletRequest request) {
        String header = request.getHeader(this.tokenHeaderName);
        return header.replace(this.tokenType + " ", "");
    }

}
