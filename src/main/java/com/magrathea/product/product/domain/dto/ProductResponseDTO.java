package com.magrathea.product.product.domain.dto;

import com.magrathea.product.product.data.ProductEntity;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String title, String image, Float price) {
    public ProductResponseDTO(ProductEntity food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
