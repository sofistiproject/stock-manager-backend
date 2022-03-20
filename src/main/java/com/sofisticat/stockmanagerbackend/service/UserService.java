package com.sofisticat.stockmanagerbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sofisticat.stockmanagerbackend.database.user.UserManager;
import com.sofisticat.stockmanagerbackend.dto.LoginRequestDTO;
import com.sofisticat.stockmanagerbackend.model.user.User;
import com.sofisticat.stockmanagerbackend.security.jwt.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserManager userManager;
    private final JwtTokenUtil jwtTokenUtil;
//    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userManager.getUserByUsername(username);
        return user;
    }

    public String handleLoginRequest(LoginRequestDTO requestDTO) {
        try {
            User user = checkIfUserIsValid(requestDTO);
            if (user != null) {
                String generatedToken = jwtTokenUtil.generateAccessToken(user);
                return generatedToken;
            }
            return jwtTokenUtil.generateAccessToken(user);
        } catch (JsonProcessingException e) {
            logger.error("Error while generating token: " + e.getMessage());
            return null;
        }

    }

    public String handleRegisterRequest(LoginRequestDTO requestDTO) {
        User user = loadUserByUsername(requestDTO.getUsername());
        if (user != null) {
            return null;
        }
        try {
            return jwtTokenUtil.generateAccessToken(user);
        } catch (JsonProcessingException e) {
            logger.error("Error while generating token: " + e.getMessage());
            return null;
        }
    }

    private User checkIfUserIsValid(LoginRequestDTO requestDTO) {
        User userByUsername = userManager.getUserByUsername("test");
        return userByUsername;
//        return passwordEncoder.matches(requestDTO.getPassword(), userByUsername.getPassword()) ? userByUsername : null;
    }
}
