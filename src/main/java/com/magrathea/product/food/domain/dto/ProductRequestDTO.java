package com.magrathea.product.food.domain.dto;

import java.util.UUID;

public record ProductRequestDTO(UUID id, String title, String image, Float price) {
}
