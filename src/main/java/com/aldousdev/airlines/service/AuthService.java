package com.aldousdev.airlines.service;

import com.aldousdev.airlines.dto.LoginRequest;
import com.aldousdev.airlines.dto.RegisterRequest;
import com.aldousdev.airlines.entity.User;
import com.aldousdev.airlines.enums.Role;
import com.aldousdev.airlines.exceptions.ResourceConflictException;
import com.aldousdev.airlines.repository.UserRepository;
import com.aldousdev.airlines.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager; // Добавлено для аутентификации

    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResourceConflictException("Email already registered");
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return jwtTokenProvider.generateToken(user);
    }

    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        return jwtTokenProvider.generateToken(user);
    }
}
