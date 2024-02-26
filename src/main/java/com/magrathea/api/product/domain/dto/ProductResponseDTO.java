package com.magrathea.api.product.domain.dto;

import com.magrathea.api.product.data.ProductEntity;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String title, String image, Float price) {
    public ProductResponseDTO(ProductEntity food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
