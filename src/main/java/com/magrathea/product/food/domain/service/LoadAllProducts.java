package com.magrathea.product.food.domain.service;

import com.magrathea.product.food.domain.dto.ProductResponseDTO;

import java.util.Set;

public interface LoadAllProducts {
    Set<ProductResponseDTO> loadAll();
}
