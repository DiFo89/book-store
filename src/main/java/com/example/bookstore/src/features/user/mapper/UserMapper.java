package com.example.bookstore.src.features.user.mapper;

import com.example.bookstore.src.features.user.dto.CreateUserDto;
import com.example.bookstore.src.features.user.dto.UpdateUserDto;
import com.example.bookstore.src.features.user.dto.UserResponseDto;
import com.example.bookstore.src.features.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntityFromUpdate(UpdateUserDto updateUserDto){
        User user = new User();

        user.setFirstName(updateUserDto.firstName());
        user.setLastName(updateUserDto.lastName());
        user.setSecondName(updateUserDto.secondName());
        user.setEmail(updateUserDto.email());
        user.setId(updateUserDto.id());
        user.setPassword(updateUserDto.password());
        user.setLogin(updateUserDto.login());
        return user;
    }
    public User toEntityFromCreate(CreateUserDto createUserDto){
        User user = new User();

        user.setFirstName(createUserDto.firstName());
        user.setLastName(createUserDto.lastName());
        user.setSecondName(createUserDto.secondName());
        user.setEmail(createUserDto.email());
        user.setPassword(createUserDto.password());
        user.setLogin(createUserDto.login());
        return user;
    }


    public UserResponseDto toResponse(User user){
        return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getSecondName(), user.getEmail(), user.getLogin());
    }
}
