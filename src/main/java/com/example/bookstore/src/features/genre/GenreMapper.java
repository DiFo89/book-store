package com.example.bookstore.src.features.genre;

import com.example.bookstore.src.features.genre.dto.CreateGenreDto;
import com.example.bookstore.src.features.genre.dto.GenreResponseDto;
import com.example.bookstore.src.features.genre.dto.UpdateGenreDto;
import com.example.bookstore.src.features.genre.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    public Genre fromCreateDto(CreateGenreDto createGenreDto){
        Genre author = new Genre();

        author.setName(createGenreDto.name());

        return author;
    }
    public Genre fromUpdateDto(UpdateGenreDto updateGenreDto){
        Genre author = new Genre();

        author.setId(updateGenreDto.id());
        author.setName(updateGenreDto.name());

        return author;
    }
    public GenreResponseDto toResponseEntity(Genre genre){
        return new GenreResponseDto(genre.getId(), genre.getName());
    }
}
