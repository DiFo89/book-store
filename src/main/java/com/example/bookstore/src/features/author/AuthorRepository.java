package com.example.bookstore.src.features.author;

import com.example.bookstore.src.features.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
