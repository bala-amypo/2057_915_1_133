package com.example.demo.repository;

import com.example.demo.entity.DemandForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemandForecastRepository extends JpaRepository<DemandForecast, Long> {

    // Required by DemandForecastServiceImpl.getForecastsForStore
    List<DemandForecast> findByStoreId(Long storeId);

    // Required by DemandForecastServiceImpl.getForecast
    Optional<DemandForecast> findByStoreIdAndProductId(Long storeId, Long productId);
}