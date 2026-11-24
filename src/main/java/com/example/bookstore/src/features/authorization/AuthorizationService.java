package com.example.bookstore.src.features.authorization;

import com.example.bookstore.src.core.security.jwt.JwtService;
import com.example.bookstore.src.features.authorization.dto.AuthorizationResponseDto;
import com.example.bookstore.src.features.authorization.dto.LoginDto;
import com.example.bookstore.src.features.authorization.dto.RegistrationDto;
import com.example.bookstore.src.features.authorization.entity.UserPrincipal;
import com.example.bookstore.src.features.authorization.exceptions.IncorrectPassword;
import com.example.bookstore.src.features.user.entity.User;
import com.example.bookstore.src.features.user.mapper.UserMapper;
import com.example.bookstore.src.features.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthorizationMapper authorizationMapper;
    private final UserMapper userMapper;

    public AuthorizationService(UserService userService, JwtService jwtService, AuthorizationMapper authorizationMapper, UserMapper userMapper){
        this.jwtService = jwtService;
        this.userService = userService;
        this.authorizationMapper = authorizationMapper;
        this.userMapper = userMapper;
    }

    public AuthorizationResponseDto registration(RegistrationDto registrationDto){
        User user = userService.createUserNative(authorizationMapper.registrationToUser(registrationDto));
        String token = jwtService.generateToken(new UserPrincipal(user));


        return new AuthorizationResponseDto(token, userMapper.toResponse(user));
    }

    public AuthorizationResponseDto login(LoginDto loginDto){
        User user = userService.getByLogin(loginDto.login());
        if(user.getPassword().equals(loginDto.password())){
            throw new IncorrectPassword(loginDto.password());
        }
        String token = jwtService.generateToken(new UserPrincipal(user));
        return new AuthorizationResponseDto(token, userMapper.toResponse(user));
    }

    public void logout(){

    }
}
