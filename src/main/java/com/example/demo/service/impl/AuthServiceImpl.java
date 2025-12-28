package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAccountRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // =====================================================
    // REGISTER
    // =====================================================
    @Override
    public void register(RegisterRequestDto registration) {

        // Duplicate email check (required by tests)
        if (userRepository.findByEmail(registration.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        UserAccount user = new UserAccount();
        user.setEmail(registration.getEmail());
        user.setFullName(registration.getFullName());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));

        // Default role if not provided
        if (registration.getRole() == null || registration.getRole().isBlank()) {
            user.setRole("ROLE_USER");
        } else {
            user.setRole(registration.getRole());
        }

        userRepository.save(user);
    }

    // =====================================================
    // LOGIN
    // =====================================================
    @Override
    public String login(AuthRequestDto authRequest) {

        UserAccount user = userRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new BadRequestException("User not found"));

        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        // ✅ FIX: generate token using EMAIL (String)
        return jwtUtil.generateToken(user.getEmail());
    }
}
