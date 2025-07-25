package com.godie.Blog.service;

import com.godie.Blog.dto.request.LoginUserRequest;
import com.godie.Blog.dto.request.RegisterUserRequest;
import com.godie.Blog.dto.response.JwtAuthenticationResponse;
import com.godie.Blog.model.user.entity.User;
import com.godie.Blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse signup(RegisterUserRequest request) {
        var user = User.builder().username(request.getUsername()).email(request.getEmail()).fullName(request.getFullName()).password(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName()).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        log.info("Başarıyla kayıt olundu");
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public JwtAuthenticationResponse signin(LoginUserRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Email adresi ya da şifre hatalı."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        return user.orElseThrow(() -> new UsernameNotFoundException("Böyle bir kullanıcı bulunamadı."));
    }
}