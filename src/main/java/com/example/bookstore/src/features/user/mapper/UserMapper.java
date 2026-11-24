package com.example.bookstore.src.features.user.mapper;

import com.example.bookstore.src.features.user.dto.CreateUserDto;
import com.example.bookstore.src.features.user.dto.UpdateUserDto;
import com.example.bookstore.src.features.user.dto.UserResponseDto;
import com.example.bookstore.src.features.user.entity.User;
import org.jspecify.annotations.NonNull;
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
        return getUser(createUserDto.firstName(), createUserDto.lastName(), createUserDto.secondName(), createUserDto.email(), createUserDto.password(), createUserDto.login() );
    }
    @NonNull
    public static User getUser(String s, String s2, String s3, String email, String password, String login) {
        User user = new User();

        user.setFirstName(s);
        user.setLastName(s2);
        user.setSecondName(s3);
        user.setEmail(email);
        user.setPassword(password);
        user.setLogin(login);
        return user;
    }


    public UserResponseDto toResponse(User user){
        return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getSecondName(), user.getEmail(), user.getLogin());
    }
}
