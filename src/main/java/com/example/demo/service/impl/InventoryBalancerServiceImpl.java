package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.entity.TransferSuggestion;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.service.InventoryBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryBalancerServiceImpl implements InventoryBalancerService {

    @Autowired
    private TransferSuggestionRepository suggestionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<TransferSuggestion> generateSuggestions(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found")
                );

        if (!product.isActive()) {
            throw new BadRequestException("Inactive product");
        }

        return suggestionRepository.findByProduct_Id(productId);
    }

    @Override
    public TransferSuggestion getSuggestionById(Long id) {
        return suggestionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Suggestion not found")
                );
    }
}
