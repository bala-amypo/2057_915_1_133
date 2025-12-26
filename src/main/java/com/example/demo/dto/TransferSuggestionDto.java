package com.example.demo.dto;

import lombok.Data;

@Data
public class TransferSuggestionDto {
    private Long id;
    private Long productId;
    private String productName;
    private Long sourceStoreId;
    private String sourceStoreName;
    private Long targetStoreId;
    private String targetStoreName;
    private Integer quantity;
    private String reason;
}