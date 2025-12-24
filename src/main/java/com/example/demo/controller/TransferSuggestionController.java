package com.example.demo.controller;

import com.example.demo.dto.TransferSuggestionDto;
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

    @GetMapping("/generate")
    public ResponseEntity<List<TransferSuggestionDto>> generateSuggestions() {
        // FIX: Removed the Long argument that was causing the error
        return ResponseEntity.ok(balancerService.generateSuggestions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferSuggestionDto> getById(@PathVariable Long id) {
        // FIX: Use getSuggestionById which we added to the interface
        TransferSuggestionDto dto = balancerService.getSuggestionById(id);
        return ResponseEntity.ok(dto);
    }
}