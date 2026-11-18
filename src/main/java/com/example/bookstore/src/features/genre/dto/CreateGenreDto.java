package com.example.bookstore.src.features.genre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateGenreDto(
    @NotBlank(message = "Genre name is required")
    @Size(min = 1)
    String name
){}
