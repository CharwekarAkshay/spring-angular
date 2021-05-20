package com.coldcoder.springbackend.domain;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Boolean isActive = true;
    private Boolean isEnabled = true;
    private Boolean isAccountLocked = false;
    private Boolean isCredentialsExpired = false;
    private String[] grantedAuthorities = { "ROLE_ADMIN", "ROLE_USER" };

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getIsAccountLocked() {
        return isAccountLocked;
    }

    public void setIsAccountLocked(Boolean isAccountLocked) {
        this.isAccountLocked = isAccountLocked;
    }

    public Boolean getIsCredentialsExpired() {
        return isCredentialsExpired;
    }

    public void setIsCredentialsExpired(Boolean isCredentialsExpired) {
        this.isCredentialsExpired = isCredentialsExpired;
    }

    public String[] getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(String[] grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

}
