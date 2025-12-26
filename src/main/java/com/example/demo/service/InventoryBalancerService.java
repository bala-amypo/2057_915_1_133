package com.example.demo.service;

import com.example.demo.entity.TransferSuggestion;
import java.util.List;
public interface InventoryBalancerService {
    // For general balancing
    List<TransferSuggestion> generateSuggestions(); 

    // For specific store balancing (required by tests)
    List<TransferSuggestion> generateSuggestions(Long storeId);

    // Added to fix the Controller error
    TransferSuggestion getSuggestionById(Long id);
}