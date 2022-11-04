package com.limyel.hammer.common.utils;

import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.modules.sys.entity.SysUserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// todo 更好的 JWT 工具
@Component
public class JwtUtil {

    public static final String CLAIM_KEY_ID = "id";

    public static final String CLAIM_KEY_CREATE_TIME = "createTime";

    @Value("${blog.jwt.secret:123456}")
    private String secret;

    @Value("${blog.jwt.expiration:3600}")
    private Integer expiration;

    /**
     * 生成token
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }

    public Claims getClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new HammerException(SysErrorCode.SYS_USER_JWT_EXPIRED);
        }
        return claims;
    }

    public Long getUserId(String token) {
        Claims claims = this.getClaims(token);
        return claims.get(CLAIM_KEY_ID, Long.class);
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public String generateToken(SysUserEntity sysUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_ID, sysUser.getId());
        claims.put(CLAIM_KEY_CREATE_TIME, new Date());
        return this.generateToken(claims);
    }
}
