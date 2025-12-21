package com.example.demo.service.impl;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final TransferSuggestionRepository transferSuggestionRepository;
    private final InventoryLevelRepository inventoryLevelRepository;
    private final DemandForecastRepository demandForecastRepository;
    private final StoreRepository storeRepository;

    // Strict constructor order: TransferRepo, InvRepo, ForecastRepo, StoreRepo
    public InventoryBalancerServiceImpl(
            TransferSuggestionRepository transferSuggestionRepository,
            InventoryLevelRepository inventoryLevelRepository,
            DemandForecastRepository demandForecastRepository,
            StoreRepository storeRepository) {
        this.transferSuggestionRepository = transferSuggestionRepository;
        this.inventoryLevelRepository = inventoryLevelRepository;
        this.demandForecastRepository = demandForecastRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {
        // Implementation of balancing logic goes here
        return transferSuggestionRepository.findAll(); 
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return transferSuggestionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Suggestion not found with id: " + id));
    }
}