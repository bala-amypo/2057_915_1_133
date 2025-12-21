package com.example.demo.controller;

import com.example.demo.entity.InventoryLevel;
import com.example.demo.service.InventoryLevelService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryLevelController {

    private final InventoryLevelService inventoryLevelService;

    public InventoryLevelController(InventoryLevelService inventoryLevelService) {
        this.inventoryLevelService = inventoryLevelService;
    }

    @PutMapping("/update")
    public InventoryLevel updateInventory(@RequestBody InventoryLevel inventory) {
        return inventoryLevelService.createOrUpdateInventory(inventory);
    }

    @GetMapping("/store/{storeId}")
    public List<InventoryLevel> getByStore(@PathVariable Long storeId) {
        return inventoryLevelService.getInventoryForStore(storeId);
    }
}