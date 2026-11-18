package com.example.bookstore.src.features.genre;

import com.example.bookstore.src.features.genre.dto.CreateGenreDto;
import com.example.bookstore.src.features.genre.dto.GenreResponseDto;
import com.example.bookstore.src.features.genre.dto.UpdateGenreDto;
import com.example.bookstore.src.features.genre.entity.Genre;
import com.example.bookstore.src.features.genre.exceptions.GenreNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    final GenreRepository genreRepository;
    final GenreMapper genreMapper;

    GenreService(GenreRepository genreRepository, GenreMapper genreMapper){
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Transactional
    public GenreResponseDto createGenre(CreateGenreDto createGenreDto){
        Genre genre = genreRepository.save(genreMapper.fromCreateDto(createGenreDto));
        return genreMapper.toResponseEntity(genre);
    }

    public void deleteGenreById(long id){
        Genre genre = genreRepository.findById(id).orElseThrow(()->new GenreNotFoundException(id));
        genreRepository.delete(genre);
    }
    public GenreResponseDto updateGenre(UpdateGenreDto updateGenreDto){
        genreRepository.findById(updateGenreDto.id()).orElseThrow(()->new GenreNotFoundException(updateGenreDto.id()));
        Genre updatedGenre = genreMapper.fromUpdateDto(updateGenreDto);
        final Genre updateResult = genreRepository.save(updatedGenre);
        return genreMapper.toResponseEntity(updateResult);
    }
    public GenreResponseDto getGenreById(long id){
        Genre genre = genreRepository.findById(id).orElseThrow(()->new GenreNotFoundException(id));
        return genreMapper.toResponseEntity(genre);
    }
    public List<GenreResponseDto> getGenres(){
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(genreMapper::toResponseEntity).toList();
    }

}
