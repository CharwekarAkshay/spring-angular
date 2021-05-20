package com.coldcoder.springbackend.domain.dto;

import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationResponseDTO {

    private String jwt;
    private Long tokenExpirationTime = 20000l;

    /**
     * 
     * Authentication Response Object creation
     * 
     * @param jwt
     * @param expirationTime
     */
    public AuthenticationResponseDTO(String jwt, Long tokenExpirationTime) {
        this.jwt = jwt;
        this.tokenExpirationTime = tokenExpirationTime;
    }

    public AuthenticationResponseDTO(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponseDTO() {
    }

    public Long getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public String getJwt() {
        return jwt;
    }

}
