package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // Matches getName()
    private String location;    // Matches getLocation()
    private String storeName;   // For the test case requirements
    private String address;
    private String region;
    private boolean active = true;
}