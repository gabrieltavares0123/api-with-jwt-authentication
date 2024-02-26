package com.magrathea.api.product.domain.service;

import com.magrathea.api.product.domain.dto.ProductResponseDTO;

import java.util.Set;

public interface LoadAllProducts {
    Set<ProductResponseDTO> loadAll();
}
