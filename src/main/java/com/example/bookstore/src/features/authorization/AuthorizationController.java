package com.example.bookstore.src.features.authorization;

import com.example.bookstore.src.features.authorization.dto.AuthorizationResponseDto;
import com.example.bookstore.src.features.authorization.dto.LoginDto;
import com.example.bookstore.src.features.authorization.dto.RegistrationDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService){
        this.authorizationService = authorizationService;
    }

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorizationResponseDto createUser(@Valid @RequestBody RegistrationDto registrationDto){
        return authorizationService.registration(registrationDto);
    }
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public AuthorizationResponseDto login(@Valid @RequestBody LoginDto loginDto){
        return authorizationService.login(loginDto);
    }
    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void logout(){
        authorizationService.logout();
    }

}
