package com.example.demo.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate; // Add this import

@Entity
@Data
public class DemandForecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer forecastQuantity;

    // FIX: Add this missing field
    private LocalDate forecastDate; 
}