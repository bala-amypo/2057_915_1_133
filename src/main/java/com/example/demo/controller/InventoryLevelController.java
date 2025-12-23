package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryLevelController {
    private final InventoryLevelService inventoryLevelService;

    public InventoryLevelController(InventoryLevelService inventoryLevelService) {
        this.inventoryLevelService = inventoryLevelService;
    }

    @PostMapping
    @PutMapping("/update")
    public ResponseEntity<InventoryLevel> updateInventory(@RequestBody InventoryLevel inventoryLevel) {
        return ResponseEntity.ok(inventoryLevelService.createOrUpdateInventory(inventoryLevel)); // [cite: 282, 283]
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<InventoryLevel>> getInventoryByStore(@PathVariable Long storeId) {
        return ResponseEntity.ok(inventoryLevelService.getInventoryForStore(storeId)); // [cite: 284]
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryLevel>> getInventoryByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryLevelService.getInventoryForProduct(productId)); // [cite: 285]
    }
}