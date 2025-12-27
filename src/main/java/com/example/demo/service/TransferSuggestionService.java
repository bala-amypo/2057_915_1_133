package com.example.demo.service;

import com.example.demo.entity.TransferSuggestion;
import java.util.List;

public interface TransferSuggestionService {
    List<TransferSuggestion> getAllSuggestions();
    void generateTransferSuggestions();
}