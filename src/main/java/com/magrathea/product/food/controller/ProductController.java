package com.magrathea.product.food.controller;

import com.magrathea.product.core.GenericResponse;
import com.magrathea.product.food.domain.dto.ProductRequestDTO;
import com.magrathea.product.food.domain.dto.ProductResponseDTO;
import com.magrathea.product.food.domain.service.LoadAllProducts;
import com.magrathea.product.food.domain.service.SaveProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("product")
public class ProductController {
    private final SaveProduct saveProduct;
    private final LoadAllProducts loadAllProducts;

    public ProductController(SaveProduct saveProduct, LoadAllProducts loadAllProducts) {
        this.saveProduct = saveProduct;
        this.loadAllProducts = loadAllProducts;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<GenericResponse<ProductResponseDTO>> save(@RequestBody ProductRequestDTO productRequest) {
        ProductResponseDTO productResponse = saveProduct.save(productRequest);
        return ResponseEntity.ok(
                GenericResponse.<ProductResponseDTO>builder()
                        .success(Boolean.TRUE)
                        .message("Product creation success!")
                        .data(productResponse)
                        .build()
        );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<GenericResponse<Set<ProductResponseDTO>>> loadAll() {
        Set<ProductResponseDTO> allProductsResponse = loadAllProducts.loadAll();
        return ResponseEntity.ok(
                GenericResponse.<Set<ProductResponseDTO>>builder()
                        .success(Boolean.TRUE)
                        .message("Load all products success!")
                        .data(allProductsResponse)
                        .build()
        );
    }
}
