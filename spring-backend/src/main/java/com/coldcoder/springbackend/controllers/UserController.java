package com.coldcoder.springbackend.controllers;

import javax.validation.Valid;

import com.coldcoder.springbackend.configurations.jwt.JWTUtil;
import com.coldcoder.springbackend.domain.dto.AuthenticationRequestDTO;
import com.coldcoder.springbackend.domain.dto.AuthenticationResponseDTO;
import com.coldcoder.springbackend.services.UserDetailsServiceImpl;
import com.coldcoder.springbackend.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO) {
        try {
            userService.login(authenticationRequestDTO.getUsername(), authenticationRequestDTO.getPassword());
        } catch (BadCredentialsException exception) {
            return ResponseEntity.ok(new AuthenticationResponseDTO("failed JWT token"));
        }

        // * If we reach this point me that means credentials are working

        // * final UserDetailsImpl userDetails = new UserDetailsImpl(
        // *
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequestDTO.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDTO(jwt));
    }
}
