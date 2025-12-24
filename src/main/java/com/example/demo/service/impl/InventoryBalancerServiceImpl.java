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
        List<InventoryLevel> allInventories = inventoryRepository.findAll();
        List<DemandForecast> allForecasts = forecastRepository.findAll();

        for (InventoryLevel destInv : allInventories) {
            int currentStock = destInv.getQuantity();
            int demand = getDemandForProductAtStore(allForecasts, destInv.getStore().getId(), destInv.getProduct().getId());

            if (currentStock < demand) {
                int needed = demand - currentStock;

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
                            break; 
                        }
                    }
                }
            }
        }
        return suggestions;
    }

    @Override
    public TransferSuggestionDto getSuggestionById(Long id) {
        return null;
    }

    private int getDemandForProductAtStore(List<DemandForecast> forecasts, Long storeId, Long productId) {
        return forecasts.stream()
                .filter(f -> f.getStore().getId().equals(storeId) && f.getProduct().getId().equals(productId))
                .mapToInt(DemandForecast::getForecastQuantity)
                .findFirst()
                .orElse(0);
    }
}