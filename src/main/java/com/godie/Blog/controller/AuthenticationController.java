package com.godie.Blog.controller;


import com.godie.Blog.dto.request.LoginUserRequest;
import com.godie.Blog.dto.request.RegisterUserRequest;
import com.godie.Blog.dto.response.JwtAuthenticationResponse;
import com.godie.Blog.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody LoginUserRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }

}