package com.example.demo.service;

import com.example.demo.entity.Store;
import java.util.List;

public interface StoreService {
    List<Store> getAllStores();
    Store getStoreById(Long id);
    Store createStore(Store store);
    Store updateStore(Long id, Store storeDetails);
    void deleteStore(Long id);
    Store getStoreByName(String name);
}