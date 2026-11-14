package com.example.bookstore.src.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Отключить CSRF для удобства тестирования
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // Разрешить анонимный доступ к /api/**
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
