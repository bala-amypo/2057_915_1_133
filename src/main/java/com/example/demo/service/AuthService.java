package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;

public interface AuthService {
    void register(RegisterRequestDto registrationDto);
    String login(AuthRequestDto loginDto); // Return String (the token)
}