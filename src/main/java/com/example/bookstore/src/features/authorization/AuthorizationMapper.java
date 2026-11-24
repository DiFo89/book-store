package com.example.bookstore.src.features.authorization;

import com.example.bookstore.src.features.authorization.dto.RegistrationDto;
import com.example.bookstore.src.features.user.entity.User;
import org.springframework.stereotype.Component;

import static com.example.bookstore.src.features.user.mapper.UserMapper.getUser;

@Component
public class AuthorizationMapper {
    public User registrationToUser(RegistrationDto registrationDto){
        return getUser(registrationDto.firstName(), registrationDto.lastName(), registrationDto.secondName(), registrationDto.email(), registrationDto.password(), registrationDto.login());
    }
}
