package com.example.demo.service;

import com.example.demo.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    void deactivateProduct(Long id);
    
    // Add these two methods to fix the Controller errors
    Product updateProduct(Long id, Product productDetails);
    void deleteProduct(Long id);
}