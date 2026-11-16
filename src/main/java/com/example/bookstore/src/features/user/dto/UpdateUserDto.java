package com.example.bookstore.src.features.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateUserDto (
    long id,

    @NotBlank(message = "First name is require")
    @Size(max = 100)
    String firstName,

    @NotBlank(message = "Last name is require")
    @Size(max = 100)
    String lastName,

    @NotBlank(message = "Second name is require")
    @Size(max = 100)
    String secondName,

    @Email(message = "Incorrect email")
    String email,

    @NotBlank(message = "Login is require")
    @Size(min = 5, max = 100)
    String login,

    @NotBlank(message = "Password is require")
    @Size(min = 5, max = 100)
    String password
){}
