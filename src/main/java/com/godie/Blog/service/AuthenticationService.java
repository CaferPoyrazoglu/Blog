package com.godie.Blog.service;

import com.godie.Blog.dto.Auth.SignInRequest;
import com.godie.Blog.dto.Auth.SignUpRequest;
import com.godie.Blog.dto.Auth.JwtAuthenticationResponse;
import com.godie.Blog.model.User;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);

    User getAuthenticatedUser();
}