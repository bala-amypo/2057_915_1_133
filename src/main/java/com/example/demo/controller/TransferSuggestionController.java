package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.TransferSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transfer-suggestions")
public class TransferSuggestionController {

    @Autowired
    private TransferSuggestionService service;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllSuggestions() {
        List<TransferSuggestion> suggestions = service.getAllSuggestions();
        
        // Mapping entities to a clean JSON response
        List<Map<String, Object>> response = suggestions.stream().map(entity -> {
            return Map.of(
                "id", entity.getId(),
                "product", Map.of(
                    "id", entity.getProduct().getId(),
                    "name", entity.getProduct().getName(),
                    "sku", entity.getProduct().getSku()
                ),
                "sourceStore", Map.of(
                    "id", entity.getSourceStore().getId(),
                    "name", entity.getSourceStore().getStoreName() // Fixed from getName()
                ),
                "targetStore", Map.of(
                    "id", entity.getTargetStore().getId(),
                    "name", entity.getTargetStore().getStoreName() // Fixed from getName()
                ),
                "quantity", entity.getSuggestedQuantity(),
                "reason", entity.getReason()
            );
        }).collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/generate")
    public ResponseEntity<Void> generateSuggestions() {
        service.generateTransferSuggestions();
        return ResponseEntity.ok().build();
    }
}