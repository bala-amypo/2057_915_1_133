package com.example.demo.service;

import com.example.demo.dto.TransferSuggestionDto; // Import the DTO
import java.util.List;

public interface InventoryBalancerService {
    List<TransferSuggestionDto> generateSuggestions();
    
    // FIX: Change return type from TransferSuggestion (Entity) to TransferSuggestionDto
    TransferSuggestionDto getSuggestionById(Long id);
}