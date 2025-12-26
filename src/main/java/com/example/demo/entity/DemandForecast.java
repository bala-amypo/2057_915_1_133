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

    // This field must match what the service calls
    private Integer forecastedDemand; 
    private LocalDate forecastDate;

    // Helper method to satisfy the specific Service call in line 70
    public Integer getForecastQuantity() {
        return forecastedDemand;
    }
}