package com.example.bookstore.src.features.user.exceptions;

public class UserWithLoginNotFound extends RuntimeException {

    public UserWithLoginNotFound(String login) {
        super("User with login " + login + " not found");
    }
}
