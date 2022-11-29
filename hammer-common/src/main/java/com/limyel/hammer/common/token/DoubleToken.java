package com.limyel.hammer.common.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.limyel.hammer.common.constant.TokenConstant;
import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.error.ErrorCode;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * @author limyel
 */
public class DoubleToken extends AbstractToken {

    private final int accessExpire;

    private final int refreshExpire;

    private final Algorithm algorithm;

    private JWTVerifier accessVerifier;

    private JWTVerifier refreshVerifier;

    private JWTCreator.Builder builder;

    /**
     * 传入加密算法、双 token 过期时间
     *
     * @param algorithm 加密算法
     * @param accessExpire 认证 token 超时时间
     * @param refreshExpire 刷新 token 超时时间
     */
    public DoubleToken(Algorithm algorithm, int accessExpire, int refreshExpire, String tokenHeaderName, String tokenType) {
        super(tokenHeaderName, tokenType);
        this.algorithm = algorithm;
        this.accessExpire = accessExpire;
        this.refreshExpire = refreshExpire;
        this.initBuilderAndVerifier();
    }

    /**
     * 不传入加密算法，传入密钥，默认使用 HMAC256 算法
     *
     * @param secret 密钥
     * @param accessExpire 认证 token 超时时间
     * @param refreshExpire 刷新 token 超时时间
     */
    public DoubleToken(String secret, int accessExpire, int refreshExpire, String tokenHeaderName, String tokenType) {
        super(tokenHeaderName, tokenType);
        this.algorithm = Algorithm.HMAC256(secret);
        this.accessExpire = accessExpire;
        this.refreshExpire = refreshExpire;
        this.initBuilderAndVerifier();
    }

    public String generateToken(String tokenType, long identity, String scope, int expireSecond) {
        return this.builder
                .withClaim("type", tokenType)
                .withClaim("identity", identity)
                .withClaim("scope", scope)
                .withExpiresAt(this.getExpireDate(expireSecond))
                .sign(this.algorithm);
    }

    public String generateToken(String tokenType, String identity, String scope, int expireSecond) {
        return this.builder
                .withClaim("type", tokenType)
                .withClaim("identity", identity)
                .withClaim("scope", scope)
                .withExpiresAt(this.getExpireDate(expireSecond))
                .sign(this.algorithm);
    }

    public Map<String, Claim> decodeAccessToken(String token) {
        DecodedJWT jwt = this.accessVerifier.verify(token);
        this.checkTokenExpired(jwt.getExpiresAt());
        this.checkTokenType(jwt.getClaim("type").asString(), TokenConstant.ACCESS_TOKEN);
        this.checkTokenScope(jwt.getClaim("scope").asString());
        return jwt.getClaims();
    }

    public Map<String, Claim> decodeRefreshToken(String token) {
        DecodedJWT jwt = this.refreshVerifier.verify(token);
        this.checkTokenExpired(jwt.getExpiresAt());
        this.checkTokenType(jwt.getClaim("type").asString(), TokenConstant.REFRESH_TOKEN);
        this.checkTokenScope(jwt.getClaim("scope").asString());
        return jwt.getClaims();
    }

    public String generateAccessToken(long identity) {
        return this.generateToken(TokenConstant.ACCESS_TOKEN, identity, TokenConstant.HAMMER_SCOPE, this.accessExpire);
    }

    public String generateAccessToken(String identity) {
        return this.generateToken(TokenConstant.ACCESS_TOKEN, identity, TokenConstant.HAMMER_SCOPE, this.accessExpire);
    }

    public String generateRefreshToken(long identity) {
        return this.generateToken(TokenConstant.REFRESH_TOKEN, identity, TokenConstant.HAMMER_SCOPE, this.refreshExpire);
    }

    public String generateRefreshToken(String identity) {
        return this.generateToken(TokenConstant.REFRESH_TOKEN, identity, TokenConstant.HAMMER_SCOPE, this.refreshExpire);
    }

    public TokensResult generateTokens(long identity) {
        String accessToken = this.generateAccessToken(identity);
        String refreshToken = this.generateRefreshToken(identity);
        return new TokensResult(accessToken, refreshToken);
    }

    public TokensResult generateTokens(String identity) {
        String accessToken = this.generateAccessToken(identity);
        String refreshToken = this.generateRefreshToken(identity);
        return new TokensResult(accessToken, refreshToken);
    }

    private void checkTokenScope(String scope) {
        if (!StringUtils.hasText(scope) || !scope.equals(TokenConstant.HAMMER_SCOPE)) {
            throw new HammerException(ErrorCode.JWT_SCOPE_INVALID);
        }
    }

    private void checkTokenType(String type, String accessType) {
        if (!StringUtils.hasText(type) || !type.equals(accessType)) {
            throw new HammerException(ErrorCode.JWT_TYPE_INVALID);
        }
    }

    private void checkTokenExpired(Date expireDate) {
        long now = System.currentTimeMillis();
        if (expireDate.getTime() < now) {
            throw new HammerException(ErrorCode.JWT_EXPIRED);
        }
    }

    public void initBuilderAndVerifier() {
        this.accessVerifier = JWT.require(this.algorithm)
                .acceptExpiresAt(this.accessExpire)
                .build();
        this.refreshVerifier = JWT.require(this.algorithm)
                .acceptExpiresAt(this.refreshExpire)
                .build();
        this.builder = JWT.create();
    }

    private Date getExpireDate(int expireSecond) {
        Date currentDate = new Date();
        return DateUtils.addSeconds(currentDate, expireSecond);
    }

}
