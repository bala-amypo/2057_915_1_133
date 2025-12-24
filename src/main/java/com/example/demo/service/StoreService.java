package com.example.demo.service;

import com.example.demo.entity.Store;
import java.util.List;

public interface StoreService {
    List<Store> getAllStores();
    
    Store getStoreById(Long id);
    
    Store createStore(Store store);
    
    // FIX: Added these methods to match the implementation
    Store updateStore(Long id, Store storeDetails);
    
    void deleteStore(Long id);
    
    Store getStoreByName(String name);
}