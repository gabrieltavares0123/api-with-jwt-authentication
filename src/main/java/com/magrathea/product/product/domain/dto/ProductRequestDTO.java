package com.magrathea.product.product.domain.dto;

import java.util.UUID;

public record ProductRequestDTO(UUID id, String title, String image, Float price) {
}
