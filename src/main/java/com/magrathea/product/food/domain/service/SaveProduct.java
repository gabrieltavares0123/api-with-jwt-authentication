package com.magrathea.product.food.domain.service;

import com.magrathea.product.food.domain.dto.ProductRequestDTO;
import com.magrathea.product.food.domain.dto.ProductResponseDTO;

public interface SaveProduct {
    ProductResponseDTO save(ProductRequestDTO foodRequest);
}
