package com.magrathea.api.auth.exception;

import org.springframework.http.HttpStatus;

public record ExceptionDto(HttpStatus httpStatus, String errorMessage) {
}
