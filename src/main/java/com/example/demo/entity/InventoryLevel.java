package com.example.demo.entity;

import lombok.Data; // <--- Add this line
import jakarta.persistence.*;

@Entity
@Data // This will now work
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