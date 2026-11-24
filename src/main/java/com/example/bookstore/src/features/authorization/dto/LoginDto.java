package com.example.bookstore.src.features.authorization.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank(message = "Login is require")
        String login,
        @NotBlank(message = "Password is require")
        String password
        ) {
}
