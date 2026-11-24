package com.example.bookstore.src.features.authorization.exceptions;

public class IncorrectPassword extends RuntimeException {
    public IncorrectPassword(String password) {
        super("The password " + password + " us incorrect for this login");
    }
}
