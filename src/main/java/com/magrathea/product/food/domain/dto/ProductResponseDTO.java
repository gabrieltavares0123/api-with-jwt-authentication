package com.magrathea.product.food.domain.dto;

import com.magrathea.product.food.data.ProductEntity;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String title, String image, Float price) {
    public ProductResponseDTO(ProductEntity food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
