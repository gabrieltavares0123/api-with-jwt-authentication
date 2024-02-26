package com.magrathea.product.product.domain.service;

import com.magrathea.product.product.data.ProductEntity;
import com.magrathea.product.product.data.ProductRepository;
import com.magrathea.product.product.domain.dto.ProductRequestDTO;
import com.magrathea.product.product.domain.dto.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService implements LoadAllProducts, SaveProduct {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<ProductResponseDTO> loadAll() {
        return productRepository.findAll().stream().map(ProductResponseDTO::new).collect(Collectors.toSet());
    }

    @Override
    public ProductResponseDTO save(ProductRequestDTO foodRequest) {
        ProductEntity productEntity = productRepository.save(new ProductEntity(foodRequest));
        return new ProductResponseDTO(productEntity);
    }
}