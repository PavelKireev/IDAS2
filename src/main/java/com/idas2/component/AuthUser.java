package com.idas2.component;

import com.idas2.db.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = -3706525489763216102L;

    private final User user;

    public static AuthUser of(
        User user,
        Collection<? extends GrantedAuthority> authorities
    ) {
        return new AuthUser(user, authorities);
    }

    private AuthUser(
        User user,
        Collection<? extends GrantedAuthority> authorities
    ) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
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
