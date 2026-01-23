package com.example.cleaning.service;


import com.example.cleaning.bean.LoginRequest;
import com.example.cleaning.bean.TokenResponse;
import com.example.cleaning.model.Tenant;
import com.example.cleaning.model.User;
import com.example.cleaning.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String access = jwtService.generateAccessToken(user);
        String refresh = jwtService.generateRefreshToken(user);
        Tenant tenant = user.getTenant();
        return new TokenResponse(access, refresh,user.getId().toString(),user.getEmail(),
                user.getName(), tenant.getName(),tenant.getId().toString(),tenant.getId().toString());
    }
}