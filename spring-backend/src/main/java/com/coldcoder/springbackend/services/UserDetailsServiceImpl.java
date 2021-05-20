package com.coldcoder.springbackend.services;

import static org.springframework.security.core.userdetails.User.withUsername;

import java.util.ArrayList;
import java.util.List;

import com.coldcoder.springbackend.domain.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    List<User> users = new ArrayList<User>();

    public UserDetailsServiceImpl() {
        User user = new User(1, "AkshayCharwekar", "$2y$12$PQx9C1eExb5ULTsrySE7mubLcHdyG9o3zt8hH1F9NIix/7mhQ4Tr2");
        this.users.add(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDetails = users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseThrow(
                () -> new UsernameNotFoundException(String.format("User with name %s does not exist", username)));
        return withUsername(userDetails.getUsername()).password(userDetails.getPassword())
                .authorities(userDetails.getGrantedAuthorities()).accountExpired(false)
                .accountLocked(userDetails.getIsAccountLocked())
                .credentialsExpired(userDetails.getIsCredentialsExpired()).disabled(!userDetails.getIsActive()).build();
    }
}
