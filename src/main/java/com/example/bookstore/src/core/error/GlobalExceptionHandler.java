package com.example.bookstore.src.core.error;

import com.example.bookstore.src.core.ApiError;
import com.example.bookstore.src.features.user.exceptions.UserLoginIsAlreadyExists;
import com.example.bookstore.src.features.user.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException ex) {
        ApiError error = new ApiError("USER_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(UserLoginIsAlreadyExists.class)
    public ResponseEntity<ApiError> handleUserLoginIsAlreadyExists(UserLoginIsAlreadyExists ex) {
        ApiError error = new ApiError("USER_ALREADY_EXISTS", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).body(error);
    }
}
