package com.example.bookstore.src.features.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UpdateBookDto(
        long id,
        @NotBlank(message = "Title is required")
        @Size(min = 1)
        String title,
        @NotNull
        List<Long> authorIds,
        @NotNull
        List<Long> genreIds
){}
