package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET =
            "your-very-secure-secret-key-that-is-long-enough";

    // Create signing key ONCE
    private final Key signingKey =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    // ================= APPLICATION TOKEN =================
    public String generateToken(UserAccount user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + getExpirationMillis()))
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // ================= TEST TOKEN =================
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + getExpirationMillis()))
                .signWith(signingKey, SignatureAlgorithm.HS256)
                .compact();
    }

    // ================= PARSING =================
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username);
    }

    public long getExpirationMillis() {
        return 1000 * 60 * 60 * 10; // 10 hours
    }
}
