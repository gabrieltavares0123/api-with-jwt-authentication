package com.magrathea.product.product.domain.service;

import com.magrathea.product.product.domain.dto.ProductRequestDTO;
import com.magrathea.product.product.domain.dto.ProductResponseDTO;

public interface SaveProduct {
    ProductResponseDTO save(ProductRequestDTO foodRequest);
}
