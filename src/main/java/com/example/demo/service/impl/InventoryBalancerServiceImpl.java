package com.example.demo.service.impl;

import com.example.demo.dto.TransferSuggestionDto;
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
            // Use .getStore().getId() and .getProduct().getId()
            Long storeId = inventory.getStore().getId();
            Long productId = inventory.getProduct().getId();

            forecastRepository.findByStoreIdAndProductId(storeId, productId).ifPresent(forecast -> {
                if (inventory.getQuantity() < forecast.getForecastQuantity()) {
                    int needed = forecast.getForecastQuantity() - inventory.getQuantity();
                    // Implement suggestion logic here
                }
            });
        }
        return suggestions;
    }

    // FIX: Add the missing method required by the Interface
    @Override
    public TransferSuggestionDto getSuggestionById(Long id) {
        // Return null or throw exception as per your requirement
        return null; 
    }
}