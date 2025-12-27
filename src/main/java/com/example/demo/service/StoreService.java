package com.example.demo.service;

import com.example.demo.entity.Store;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(Store store) {
        store.setActive(true);
        return storeRepository.save(store);
    }

    public Store updateStore(Long id, Store update) {
        Store s = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));

        s.setStoreName(update.getStoreName());
        s.setAddress(update.getAddress());
        s.setRegion(update.getRegion());   // REQUIRED
        s.setActive(update.isActive());

        return storeRepository.save(s);
    }

    public void deactivateStore(Long id) {
        Store s = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
        s.setActive(false);
        storeRepository.save(s);
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found"));
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }
}
