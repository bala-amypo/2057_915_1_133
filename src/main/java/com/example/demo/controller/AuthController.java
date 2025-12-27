package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequestDto registration) {
        authService.register(registration);
        // Returning JSON instead of plain string for consistency
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequestDto authRequest) {
        String token = authService.login(authRequest);
        
        // This fix wraps the raw string into a JSON object: {"token": "..."}
        // This allows your test's JSON parser to find the 'token' field.
        return ResponseEntity.ok(Map.of("token", token));
    }
}