package com.example.bookstore.src.features.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(length = 100)
    private String secondName;

    @Column(length = 100)
    private String email;

    @Column(length = 100, unique = true)
    private String login;

    @Column(length = 100)
    private String password;


}
