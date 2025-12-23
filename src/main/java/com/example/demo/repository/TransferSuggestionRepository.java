package com.example.demo.repository;

import com.example.demo.entity.TransferSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransferSuggestionRepository extends JpaRepository<TransferSuggestion, Long> {

    // ADD THIS METHOD
    List<TransferSuggestion> findBySourceStoreId(Long storeId);

    // Also ensure this method exists for HQL tests as per requirements
    List<TransferSuggestion> findByProduct_Id(Long productId);
}