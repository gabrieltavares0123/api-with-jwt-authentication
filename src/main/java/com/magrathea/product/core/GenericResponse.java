package com.magrathea.product.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {
    private Boolean success;
    private String message;
    private T data;
}
