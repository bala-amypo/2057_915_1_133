package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAll(Exception ex) {
        String msg = ex.getMessage() != null ? ex.getMessage() : "An error occurred";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (msg.contains("not found")) {
            status = HttpStatus.NOT_FOUND;
        }

        return ResponseEntity.status(status).body(Map.of("error", msg));
    }
}