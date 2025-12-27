package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // This fixes getStoreName, getAddress, getRegion, isActive, setActive
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeName;
    private String address;
    private String region;
    private boolean active = true;
}