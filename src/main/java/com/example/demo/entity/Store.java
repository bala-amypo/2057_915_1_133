package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String storeName; // Field name must be storeName per spec [cite: 68]
    
    private String address;
    private String region;
    private Boolean active = true; // Default to true [cite: 72]

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}