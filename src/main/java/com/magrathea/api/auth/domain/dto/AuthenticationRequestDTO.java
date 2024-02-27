package com.magrathea.api.auth.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticationRequestDTO(
        @NotBlank
        @Size.List({
                @Size(min = 3, message = "Username is too short."),
                @Size(max = 50, message = "Username is too long.")
        })
        String username,
        @NotBlank
        @Size.List({
                @Size(min = 4, message = "Password is too short."),
                @Size(max = 12, message = "Password is too long.")
        })
        String password
) {
}
