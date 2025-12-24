package com.example.demo.controller;

import com.example.demo.entity.DemandForecast;
import com.example.demo.service.DemandForecastService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forecasts")
public class DemandForecastController {

    private final DemandForecastService demandForecastService;

    // Required constructor injection [cite: 201]
    public DemandForecastController(DemandForecastService demandForecastService) {
        this.demandForecastService = demandForecastService;
    }

    /**
     * Creates a new demand forecast record.
     * Validates that the forecast date is in the future[cite: 115, 260].
     */
    @PostMapping
    public ResponseEntity<DemandForecast> createForecast(@RequestBody DemandForecast forecast) {
        return ResponseEntity.ok(demandForecastService.createForecast(forecast));
    }

    /**
     * Retrieves all forecasts for a specific store[cite: 257].
     */
    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<DemandForecast>> getForecastsForStore(@PathVariable Long storeId) {
        return ResponseEntity.ok(demandForecastService.getForecastsForStore(storeId));
    }

    /**
     * Fetches a specific forecast for a given store and product[cite: 287].
     */
    @GetMapping("/store/{storeId}/product/{productId}")
    public ResponseEntity<DemandForecast> getForecast(
            @PathVariable Long storeId, 
            @PathVariable Long productId) {
        return ResponseEntity.ok(demandForecastService.getForecast(storeId, productId));
    }
}