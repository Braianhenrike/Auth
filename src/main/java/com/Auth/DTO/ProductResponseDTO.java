package com.Auth.DTO;

import com.Auth.entities.Product;

public record ProductResponseDTO(String id, String name, Integer price) {
    public ProductResponseDTO(Product product){
        this(null, product.getName(), product.getPrice());
    }
}