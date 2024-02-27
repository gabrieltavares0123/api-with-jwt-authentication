package com.magrathea.api.auth.controller;

import com.magrathea.api.auth.domain.dto.AuthenticationRequestDTO;
import com.magrathea.api.auth.domain.dto.AuthenticationResponseDTO;
import com.magrathea.api.auth.domain.dto.RegisterRequestDTO;
import com.magrathea.api.auth.domain.service.AuthenticationService;
import com.magrathea.api.core.EmptyResponseDTO;
import com.magrathea.api.core.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<GenericResponse<AuthenticationResponseDTO>> login(@RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO) {
        AuthenticationResponseDTO authenticationResponseDto = authenticationService.login(authenticationRequestDTO);

        return ResponseEntity.ok(
                GenericResponse
                        .<AuthenticationResponseDTO>builder()
                        .success(Boolean.TRUE)
                        .message("Login successful")
                        .data(authenticationResponseDto)
                        .build()
        );
    }

    @PostMapping("/register")
    public ResponseEntity<GenericResponse<EmptyResponseDTO>> register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        this.authenticationService.register(registerRequestDTO);
        return ResponseEntity.ok(
                GenericResponse
                        .<EmptyResponseDTO>builder()
                        .success(Boolean.TRUE)
                        .message("Register Success!")
                        .data(null)
                        .build()
        );
    }
}
