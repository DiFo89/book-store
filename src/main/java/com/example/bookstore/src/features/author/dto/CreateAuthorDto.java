package com.example.bookstore.src.features.author.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAuthorDto (
    @NotBlank(message = "First name is required")
    @Size(min = 1)
    String firstName,
    String secondName,

    String lastName
){}
