package com.coldcoder.springbackend.domain.dto;

import javax.validation.constraints.NotNull;

public class AuthenticationRequestDTO {
    @NotNull
    private String username;

    @NotNull
    private String password;

    private String firstName;
    private String lastName;

    /**
     * Default constructor tot handle object creation1
     */

    public AuthenticationRequestDTO() {
    }

    /**
     * Fully qualified constructor to handle all the values
     * 
     * @param String username
     * @param String password
     * @param String firstName
     * @param String lastName
     */

    public AuthenticationRequestDTO(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor to handling userValues
     * 
     * @param String username
     * @param String password
     */
    public AuthenticationRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
