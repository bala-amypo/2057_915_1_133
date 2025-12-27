package com.example.demo.service.impl;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.service.TransferSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferSuggestionServiceImpl implements TransferSuggestionService {

    @Autowired
    private TransferSuggestionRepository repository;

    @Override
    public List<TransferSuggestion> getAllSuggestions() {
        return repository.findAll();
    }

    @Override
    public void generateTransferSuggestions() {
        // Business logic for generating suggestions would go here
        // For now, this satisfies the interface so the code compiles
    }
}