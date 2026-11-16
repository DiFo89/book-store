package com.example.bookstore.src.features.author.dto;

public record AuthorResponseDto (
    long id,

    String firstName,
    String lastName,
    String secondName
){}
