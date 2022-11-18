package com.limyel.hammer.modules.security.model.entity;

import com.limyel.hammer.modules.sys.model.entity.SysUserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author limyel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUserDetails implements UserDetails {

    private SysUserEntity sysUser;

    private Set<String> permissions;

    private String token;

    private Long loginTime;

    private Long expireTime;

    private Set<SimpleGrantedAuthority> authorities;

    public SecurityUserDetails(SysUserEntity sysUser, Set<String> permissions) {
        this.sysUser = sysUser;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (!ObjectUtils.isEmpty(authorities)) {
            return authorities;
        }

        authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        return authorities;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
