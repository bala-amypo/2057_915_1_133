package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data // Ensure this is present
public class InventoryLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Product product;

    private Integer quantity;
}