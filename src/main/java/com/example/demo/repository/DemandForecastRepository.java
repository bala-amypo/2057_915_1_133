package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class DemandForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Field used by the Test class (t18, t19, t35)
    private Integer forecastedDemand; 
    
    private LocalDate forecastDate;

    /**
     * Helper method to satisfy the InventoryBalancerServiceImpl call:
     * DemandForecast::getForecastQuantity
     */
    public Integer getForecastQuantity() {
        return forecastedDemand;
    }
}