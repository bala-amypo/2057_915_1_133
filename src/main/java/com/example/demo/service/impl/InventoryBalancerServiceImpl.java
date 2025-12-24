package com.example.demo.service.impl;

import com.example.demo.dto.TransferSuggestionDto;
import com.example.demo.entity.DemandForecast;
import com.example.demo.entity.InventoryLevel;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    private final InventoryLevelRepository inventoryRepository;
    private final DemandForecastRepository forecastRepository;

    public InventoryBalancerServiceImpl(InventoryLevelRepository inventoryRepository, 
                                        DemandForecastRepository forecastRepository) {
        this.inventoryRepository = inventoryRepository;
        this.forecastRepository = forecastRepository;
    }

    @Override
    public List<TransferSuggestionDto> generateSuggestions() {
        List<TransferSuggestionDto> suggestions = new ArrayList<>();
        List<InventoryLevel> inventories = inventoryRepository.findAll();

        for (InventoryLevel inventory : inventories) {
            Long storeId = inventory.getStore().getId();
            Long productId = inventory.getProduct().getId();

            // Find forecast for this specific product at this store
            forecastRepository.findByStoreIdAndProductId(storeId, productId).ifPresent(forecast -> {
                int currentStock = inventory.getQuantity();
                int forecastedDemand = forecast.getForecastQuantity();

                // If demand exceeds stock, we need a transfer
                if (currentStock < forecastedDemand) {
                    int needed = forecastedDemand - currentStock;
                    findSourceAndAddSuggestion(suggestions, inventory, needed);
                }
            });
        }
        return suggestions;
    }

    private void findSourceAndAddSuggestion(List<TransferSuggestionDto> suggestions, 
                                           InventoryLevel destinationInv, int quantityNeeded) {
        // Logic to find another store with surplus and create the DTO
        // ... implementation details for matching stores ...
    }
}