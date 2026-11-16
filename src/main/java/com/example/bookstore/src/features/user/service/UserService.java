package com.example.bookstore.src.features.user.service;

import com.example.bookstore.src.features.user.dto.CreateUserDto;
import com.example.bookstore.src.features.user.dto.UpdateUserDto;
import com.example.bookstore.src.features.user.dto.UserResponseDto;
import com.example.bookstore.src.features.user.entity.User;
import com.example.bookstore.src.features.user.exceptions.UserLoginIsAlreadyExists;
import com.example.bookstore.src.features.user.exceptions.UserNotFoundException;
import com.example.bookstore.src.features.user.mapper.UserMapper;
import com.example.bookstore.src.features.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserResponseDto createUser(CreateUserDto createUserDto){
        if(userRepository.existsByLogin(createUserDto.login())){
            throw new UserLoginIsAlreadyExists(createUserDto.login());
        }
        User user = userRepository.save(userMapper.toEntityFromCreate(createUserDto));
        return userMapper.toResponse(user);
    }

    public void deleteUserById(long id){
       User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
       userRepository.delete(user);
    }
    public UserResponseDto updateUser(UpdateUserDto updateUserDto){
        userRepository.findById(updateUserDto.id()).orElseThrow(()->new UserNotFoundException(updateUserDto.id()));
        User updatedUser = userMapper.toEntityFromUpdate(updateUserDto);
        final User updateResult = userRepository.save(updatedUser);
        return userMapper.toResponse(updateResult);
    }
    public UserResponseDto getUserById(long id){
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        return userMapper.toResponse(user);
    }
    public List<UserResponseDto> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toResponse).toList();
    }
}
