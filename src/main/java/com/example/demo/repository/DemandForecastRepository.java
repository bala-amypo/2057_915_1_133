package com.example.demo.repository;

import com.example.demo.entity.DemandForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DemandForecastRepository extends JpaRepository<DemandForecast, Long> {
    
    // Add this line to fix the compilation error
    Optional<DemandForecast> findByStoreIdAndProductId(Long storeId, Long productId);

    // This is likely also used in your service
    List<DemandForecast> findByStoreId(Long storeId);
}