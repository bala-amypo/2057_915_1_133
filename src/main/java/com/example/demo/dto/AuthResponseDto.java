package com.example.demo.dto;

import lombok.Data;
import java.util.Date;

@Data
public class AuthResponseDto {
    private String token;     // The generated JWT [cite: 145]
    private Date expiresAt;   // Token expiration timestamp [cite: 145]
    
    // Default constructor
    public AuthResponseDto() {}

    // Convenience constructor
    public AuthResponseDto(String token, Date expiresAt) {
        this.token = token;
        this.expiresAt = expiresAt;
    }
}