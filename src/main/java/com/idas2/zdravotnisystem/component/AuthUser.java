package com.idas2.zdravotnisystem.component;

import com.idas2.zdravotnisystem.db.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class AuthUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = -3706525489763216102L;

    private User user;
    private Boolean simulated;
    private Integer adminId;

    public static AuthUser of(
        User user,
        Collection<? extends GrantedAuthority> authorities
    ) {
        return new AuthUser(user, authorities);
    }

    public static AuthUser of(
        User user,
        Collection<? extends GrantedAuthority> authorities,
        Boolean simulated,
        Integer adminId
    ) {
        return new AuthUser(user, authorities, simulated, adminId);
    }

    public static AuthUser of(){
        return new AuthUser();
    }

    private AuthUser() {
        super("Unknown User", "password", Collections.emptyList());
        this.user = null;
        this.simulated = false;
        this.adminId = null;

    }

    private AuthUser(
        User user,
        Collection<? extends GrantedAuthority> authorities
    ) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
        this.simulated = false;
        this.adminId = null;
    }

    private AuthUser(
        User user,
        Collection<? extends GrantedAuthority> authorities,
        Boolean simulated,
        Integer adminId
    ) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
        this.simulated = simulated;
        this.adminId = adminId;
    }

    public User getUser() {
        return user;
    }

    public AuthUser setUser(User user) {
        this.user = user;
        return this;
    }

    public Boolean getSimulated() {
        return simulated;
    }

    public AuthUser setSimulated(Boolean simulated) {
        this.simulated = simulated;
        return this;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public AuthUser setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
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
