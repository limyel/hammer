package com.limyel.hammer.common.filter;

import com.auth0.jwt.interfaces.Claim;
import com.limyel.hammer.common.constant.TokenConstant;
import com.limyel.hammer.common.exception.HammerException;
import com.limyel.hammer.common.exception.SysErrorCode;
import com.limyel.hammer.common.exception.error.ErrorCode;
import com.limyel.hammer.common.token.DoubleToken;
import com.limyel.hammer.common.token.Token;
import com.limyel.hammer.modules.security.model.entity.SecurityUserDetails;
import com.limyel.hammer.modules.sys.entity.SysUserEntity;
import com.limyel.hammer.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private DoubleToken doubleToken;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<Map<String, Claim>> optionalClaims = Optional.ofNullable(this.resolveToken(request));
        if (optionalClaims.isPresent()) {
            Map<String, Claim> claims = optionalClaims.get();
            String identity = claims.get("identity").asString();

            SecurityUserDetails userDetails = (SecurityUserDetails) userDetailsService.loadUserByUsername(identity);

            // 存入 SecurityContextHolder
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        // 放行
        filterChain.doFilter(request, response);
    }

    private Map<String, Claim> resolveToken(HttpServletRequest request) {
        String authorization = request.getHeader(TokenConstant.AUTHORIZATION_HEADER);
        if (!StringUtils.hasText(authorization)) {
            return null;
        }
        String[] splits = authorization.split(" ");
        if (splits.length != 2) {
            throw new HammerException(ErrorCode.JWT_RESOLVE_FAILED);
        }
        String scheme = splits[0];
        String tokenStr = splits[1];
        if (!Pattern.matches(TokenConstant.BEARER_PATTERN, scheme)) {
            throw new HammerException(ErrorCode.JWT_RESOLVE_FAILED);
        }

        return doubleToken.decodeAccessToken(tokenStr);
    }

}
