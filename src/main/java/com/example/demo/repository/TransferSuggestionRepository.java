package com.example.demo.repository;

import com.example.demo.entity.TransferSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransferSuggestionRepository extends JpaRepository<TransferSuggestion, Long> {
    
    // This allows the test to find suggestions linked to a specific product
    List<TransferSuggestion> findByProduct_Id(Long productId);
}