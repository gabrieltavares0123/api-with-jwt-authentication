package com.magrathea.product.product.domain.service;

import com.magrathea.product.product.domain.dto.ProductResponseDTO;

import java.util.Set;

public interface LoadAllProducts {
    Set<ProductResponseDTO> loadAll();
}
