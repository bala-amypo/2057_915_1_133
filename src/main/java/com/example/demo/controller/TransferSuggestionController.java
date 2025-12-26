package com.example.demo.controller;

import com.example.demo.dto.TransferSuggestionDto;
import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/suggestions")
public class TransferSuggestionController {

    @Autowired
    private InventoryBalancerService balancerService;

    @GetMapping
    public ResponseEntity<List<TransferSuggestionDto>> getAllSuggestions() {
        List<TransferSuggestion> suggestions = balancerService.generateSuggestions();
        List<TransferSuggestionDto> dtos = suggestions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferSuggestionDto> getSuggestion(@PathVariable Long id) {
        TransferSuggestion suggestion = balancerService.getSuggestionById(id);
        if (suggestion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDto(suggestion));
    }

    private TransferSuggestionDto convertToDto(TransferSuggestion entity) {
        TransferSuggestionDto dto = new TransferSuggestionDto();
        dto.setId(entity.getId());
        
        if (entity.getProduct() != null) {
            dto.setProductId(entity.getProduct().getId());
            dto.setProductName(entity.getProduct().getName());
        }
        
        if (entity.getSourceStore() != null) {
            dto.setSourceStoreId(entity.getSourceStore().getId());
            dto.setSourceStoreName(entity.getSourceStore().getName());
        }
        
        if (entity.getTargetStore() != null) {
            dto.setTargetStoreId(entity.getTargetStore().getId());
            dto.setTargetStoreName(entity.getTargetStore().getName());
        }
        
        dto.setQuantity(entity.getSuggestedQuantity());
        dto.setReason(entity.getReason());
        return dto;
    }
}