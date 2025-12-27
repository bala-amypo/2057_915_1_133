package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName; // Use "storeName" NOT "name"
    private String address;
    private String region;    // Use "region" NOT "location"
    private boolean active = true;
}