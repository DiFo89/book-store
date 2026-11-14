package com.example.bookstore.src.features.user.exceptions;

public class UserNotFoundException extends  RuntimeException {
    public UserNotFoundException(long id){
        super("User with id " + id + " not found");
    }
}
