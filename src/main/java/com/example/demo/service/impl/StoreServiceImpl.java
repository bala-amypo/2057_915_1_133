package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    // Constructor injection
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + id));
    }

    // ADD THIS METHOD TO FIX THE COMPILATION ERROR
    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}