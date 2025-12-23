package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service; // Crucial import

@Service // This is likely the missing annotation
public class AuthServiceImpl implements AuthService {

    // Your repository and security dependencies...
    
    @Override
    public void register(RegisterRequestDto dto) {
        // implementation
    }

    @Override
    public AuthResponseDto login(AuthRequestDto dto) {
        // implementation
        return null; 
    }
}