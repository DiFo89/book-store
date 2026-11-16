package com.example.bookstore.src.features.author.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("Author with id " + id + " not found");
    }
}
