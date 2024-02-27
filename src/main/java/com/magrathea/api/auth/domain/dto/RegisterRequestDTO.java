package com.magrathea.api.auth.domain.dto;

import com.magrathea.api.auth.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
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
        String password,
        @NotNull
        UserRole role) {
}
