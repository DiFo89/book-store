package com.example.bookstore.src.features.user.exceptions;

public class UserLoginIsAlreadyExists extends RuntimeException {
    public UserLoginIsAlreadyExists(String login){
        super("This user login " + login + " is already exists");
    }
}
