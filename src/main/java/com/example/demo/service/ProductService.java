package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    
    // Add these two signatures:
    Product updateProduct(Long id, Product productDetails);
    void deleteProduct(Long id);
}