package com.example.demo.service.impl;

import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores() { return storeRepository.findAll(); }

    @Override
    public Store getStoreById(Long id) { 
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found")); 
    }

    @Override
    public Store createStore(Store store) { return storeRepository.save(store); }

    @Override
    public Store updateStore(Long id, Store details) {
        Store store = getStoreById(id);
        store.setStoreName(details.getStoreName());
        store.setAddress(details.getAddress());
        store.setRegion(details.getRegion());
        store.setActive(details.isActive());
        return storeRepository.save(store);
    }

    @Override
    public void deleteStore(Long id) {
        Store store = getStoreById(id);
        store.setActive(false);
        storeRepository.save(store);
    }

    @Override
    public void deactivateStore(Long id) {
        deleteStore(id);
    }
}