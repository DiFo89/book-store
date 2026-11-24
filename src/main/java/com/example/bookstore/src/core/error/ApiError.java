package com.example.bookstore.src.core.error;

import java.time.Instant;

public record ApiError (
    String code,
    String message,
    Instant timestamp,
    String path

){
    public ApiError(String code, String message, String path){
        this(code, message, Instant.now(), path);
    }
}
