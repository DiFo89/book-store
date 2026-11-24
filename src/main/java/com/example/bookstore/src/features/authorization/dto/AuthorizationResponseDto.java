package com.example.bookstore.src.features.authorization.dto;

import com.example.bookstore.src.features.user.dto.UserResponseDto;

public class AuthorizationResponseDto {
    public String token;
    public UserResponseDto user;

    public AuthorizationResponseDto(String token, UserResponseDto user){
        this.token = token;
        this.user = user;
    }
}
