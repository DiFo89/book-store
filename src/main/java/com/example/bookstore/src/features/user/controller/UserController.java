package com.example.bookstore.src.features.user.controller;

import com.example.bookstore.src.features.user.dto.CreateUserDto;
import com.example.bookstore.src.features.user.dto.UpdateUserDto;
import com.example.bookstore.src.features.user.dto.UserResponseDto;
import com.example.bookstore.src.features.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@Valid @RequestBody CreateUserDto createUserDto){
        return userService.createUser(createUserDto);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
    }

    @PatchMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto updateUser(@Valid @RequestBody UpdateUserDto updateUserDto){
        return userService.updateUser(updateUserDto);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponseDto> getUserById(){
        return userService.getUsers();
    }
}
