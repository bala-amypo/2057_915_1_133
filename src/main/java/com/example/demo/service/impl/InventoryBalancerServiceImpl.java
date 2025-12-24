package com.example.demo.service.impl;

import com.example.demo.dto.TransferSuggestionDto;
import com.example.demo.entity.InventoryLevel;
import com.example.demo.repository.DemandForecastRepository;
import com.example.demo.repository.InventoryLevelRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Override
public List<TransferSuggestionDto> generateSuggestions() {
    List<TransferSuggestionDto> suggestions = new ArrayList<>();
    List<InventoryLevel> allInventories = inventoryRepository.findAll();
    List<DemandForecast> allForecasts = forecastRepository.findAll();

    for (InventoryLevel destInv : allInventories) {
        // Calculate what this store needs
        int currentStock = destInv.getQuantity();
        int demand = getDemandForProductAtStore(allForecasts, destInv.getStore().getId(), destInv.getProduct().getId());

        if (currentStock < demand) {
            int needed = demand - currentStock;
            
            // Look for a source store that has surplus
            for (InventoryLevel sourceInv : allInventories) {
                if (sourceInv.getProduct().getId().equals(destInv.getProduct().getId()) && 
                    !sourceInv.getStore().getId().equals(destInv.getStore().getId())) {
                    
                    int sourceDemand = getDemandForProductAtStore(allForecasts, sourceInv.getStore().getId(), sourceInv.getProduct().getId());
                    int surplus = sourceInv.getQuantity() - sourceDemand;

                    if (surplus > 0) {
                        int transferQty = Math.min(needed, surplus);
                        suggestions.add(new TransferSuggestionDto(
                            sourceInv.getStore().getId(), sourceInv.getStore().getName(),
                            destInv.getStore().getId(), destInv.getStore().getName(),
                            destInv.getProduct().getId(), destInv.getProduct().getName(),
                            transferQty
                        ));
                        break; // Move to next shortage after finding a source
                    }
                }
            }
        }
    }
    return suggestions;
}

private int getDemandForProductAtStore(List<DemandForecast> forecasts, Long storeId, Long productId) {
    return forecasts.stream()
            .filter(f -> f.getStore().getId().equals(storeId) && f.getProduct().getId().equals(productId))
            .mapToInt(DemandForecast::getForecastQuantity)
            .findFirst()
            .orElse(0);
}