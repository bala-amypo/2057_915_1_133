package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // This fixes getId, getProduct, getSourceStore, getTargetStore, etc.
public class TransferSuggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Store sourceStore;

    @ManyToOne
    private Store targetStore;

    private Integer suggestedQuantity;
    private String reason;
}