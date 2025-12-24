package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferSuggestionDto {
    private Long sourceStoreId;
    private String sourceStoreName;
    private Long destinationStoreId;
    private String destinationStoreName;
    private Long productId;
    private String productName;
    private Integer quantity;
}