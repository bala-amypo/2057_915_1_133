package com.example.demo.service.impl;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    @Autowired
    private TransferSuggestionRepository suggestionRepository;

    @Override
    public List<TransferSuggestion> generateSuggestions() {
        return suggestionRepository.findAll();
    }

    @Override
    public List<TransferSuggestion> generateSuggestions(Long storeId) {
        // For now, return all; logic can be added to filter by storeId
        return suggestionRepository.findAll();
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return suggestionRepository.findById(id).orElse(null);
    }
}