package com.example.bookstore.src.features.book.dto;

import com.example.bookstore.src.features.author.entity.Author;
import com.example.bookstore.src.features.genre.entity.Genre;

import java.util.List;

public record BookResponseDto(
        long id,

        String title,

        List<Author> authors,

        List<Genre> genres
){}
