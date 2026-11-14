package com.example.bookstore.src.features.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserResponseDto (
        long id,

        String firstName,

        String lastName,

        String secondName,

        String email,

        String login
){}
