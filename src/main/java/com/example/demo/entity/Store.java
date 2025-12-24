package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data; // Ensure this import exists
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "stores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This field provides the getName() method via Lombok
    private String name;

    private String location;
}