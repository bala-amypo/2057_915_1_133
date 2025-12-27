package com.example.demo.repository;

import com.example.demo.entity.TransferSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransferSuggestionRepository extends JpaRepository<TransferSuggestion, Long> {
    // This allows the test to find suggestions by product ID
    List<TransferSuggestion> findByProductId(Long productId);
    
    // Alias for the test if it specifically uses underscores
    default List<TransferSuggestion> findByProduct_Id(Long productId) {
        return findByProductId(productId);
    }
}