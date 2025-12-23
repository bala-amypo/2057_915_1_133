package com.example.demo.repository;

import com.example.demo.entity.TransferSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransferSuggestionRepository extends JpaRepository<TransferSuggestion, Long> {
    
    // Add this line to resolve the compilation error:
    List<TransferSuggestion> findBySourceStoreIdOrDestinationStoreId(Long sourceStoreId, Long destinationStoreId);
}