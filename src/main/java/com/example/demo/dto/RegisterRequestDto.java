package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String email;    // Must be unique [cite: 138]
    private String fullName; [cite: 138]
    private String password; [cite: 138]
    private String role;     // e.g., ROLE_ADMIN, ROLE_USER [cite: 138]
}