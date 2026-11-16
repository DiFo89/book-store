package com.example.bookstore.src.core.error;

import com.example.bookstore.src.core.ApiError;
import com.example.bookstore.src.features.author.exceptions.AuthorNotFoundException;
import com.example.bookstore.src.features.user.exceptions.UserLoginIsAlreadyExists;
import com.example.bookstore.src.features.user.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
        ApiError error = new ApiError("USER_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(UserLoginIsAlreadyExists.class)
    public ResponseEntity<ApiError> handleUserLoginIsAlreadyExists(UserLoginIsAlreadyExists ex, HttpServletRequest request) {
        ApiError error = new ApiError("USER_ALREADY_EXISTS", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ApiError> handleAuthorNotFound(AuthorNotFoundException ex, HttpServletRequest request) {
        ApiError error = new ApiError("AUTHOR_NOT_FOUND", ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
