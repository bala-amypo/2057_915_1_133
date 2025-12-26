package com.example.demo.repository;

import com.example.demo.entity.DemandForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DemandForecastRepository extends JpaRepository<DemandForecast, Long> {
    Optional<DemandForecast> findByStoreIdAndProductId(Long storeId, Long productId);
    List<DemandForecast> findByStoreId(Long storeId);
    
    // Required by the test suite for specific lookups
    List<DemandForecast> findByProduct_Id(Long productId);
    List<DemandForecast> findByStore_Id(Long storeId);
}