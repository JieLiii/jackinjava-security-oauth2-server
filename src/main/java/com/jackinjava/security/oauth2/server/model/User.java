package com.jackinjava.security.oauth2.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户
 *
 * @author lijie
 * @date 2020/3/9 23:41
 */
public class User implements Serializable, UserDetails {
    private int userId;
    private String username;
    private String password;
    private int mobile;
    private int sex;
    private boolean enabled;
    private List<Permission> permissions;

    /**
     * 权限列表
     * @return
     */
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(permissions != null) {
            for (Permission permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission.getPermissionAbbr()));
            }
        }
        return authorities;
    }

    /**
     * 账户是否生效
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否锁定
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 帐户密码是否过期，一般有的密码要求性高的系统会使用到，比较每隔一段时间就要求用户重置密码
     * @return
     */
    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
