package com.example.demo.service;

import com.example.demo.entity.TransferSuggestion;
import java.util.List;

public interface InventoryBalancerService {
    // Updated to accept the Store ID parameter the test is sending
    List<TransferSuggestion> generateSuggestions(Long storeId);
}