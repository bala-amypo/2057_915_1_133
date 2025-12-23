package com.example.demo.service.impl;

import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    // 1. Declare the fields
    private final TransferSuggestionRepository transferSuggestionRepository;
    private final InventoryLevelRepository inventoryLevelRepository;
    private final DemandForecastRepository demandForecastRepository;
    private final StoreRepository storeRepository;

    // 2. Use the MANDATORY constructor order (Transfer, Inventory, Forecast, Store)
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

    // Your methods (generateSuggestions, etc.) can now use transferSuggestionRepository
}