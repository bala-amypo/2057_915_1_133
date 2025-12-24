package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds a product by its unique SKU. 
     * Used by ProductServiceImpl to enforce SKU uniqueness[cite: 153, 236].
     */
    Product findBySku(String sku);

    /**
     * Standard findAll method used when retrieving inventories 
     * and for HQL-based repository tests[cite: 154, 155].
     */
    List<Product> findAll();
}