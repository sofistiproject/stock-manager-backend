package com.sofisticat.stockmanagerbackend.controller;

import com.sofisticat.stockmanagerbackend.dto.LoginRequestDTO;
import com.sofisticat.stockmanagerbackend.model.user.User;
import com.sofisticat.stockmanagerbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> loginWithUsernameAndPassword(@RequestBody LoginRequestDTO requestDTO) {
        String token = userService.handleLoginRequest(requestDTO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerPostRequest(@RequestBody LoginRequestDTO requestDTO) {
        // TODO: ObjectMapperi utile try catch ile taşı
        String token = userService.handleRegisterRequest(requestDTO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> getUserDetails() {
        return new ResponseEntity<>(userService.loadUserByUsername("test"),HttpStatus.OK);
    }
    // login []
    // register []
    // user info []
    // admin info []
    // attach user to a mission []
    // alert user to do something []
}
