package com.magrathea.api.product.domain.service;

import com.magrathea.api.product.domain.dto.ProductRequestDTO;
import com.magrathea.api.product.domain.dto.ProductResponseDTO;

public interface SaveProduct {
    ProductResponseDTO save(ProductRequestDTO foodRequest);
}
