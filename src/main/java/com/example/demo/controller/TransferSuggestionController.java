package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class TransferSuggestionController {
    private final InventoryBalancerService balancerService;

    public TransferSuggestionController(InventoryBalancerService balancerService) {
        this.balancerService = balancerService;
    }

    @PostMapping("/generate/{productId}")
    public ResponseEntity<List<TransferSuggestion>> generate(@PathVariable Long productId) {
        return ResponseEntity.ok(balancerService.generateSuggestions(productId)); // 
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<TransferSuggestion>> getByStore(@PathVariable Long storeId) {
        return ResponseEntity.ok(balancerService.getSuggestionsForStore(storeId)); // [cite: 289]
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferSuggestion> getById(@PathVariable Long id) {
        return ResponseEntity.ok(balancerService.getSuggestionById(id)); // [cite: 290]
    }
}