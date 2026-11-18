package com.example.bookstore.src.features.genre;

import com.example.bookstore.src.features.genre.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
