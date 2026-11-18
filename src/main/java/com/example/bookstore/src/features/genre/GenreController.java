package com.example.bookstore.src.features.genre;

import com.example.bookstore.src.features.genre.dto.CreateGenreDto;
import com.example.bookstore.src.features.genre.dto.GenreResponseDto;
import com.example.bookstore.src.features.genre.dto.UpdateGenreDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/genres")
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public GenreResponseDto createGenre(@Valid @RequestBody CreateGenreDto createGenreDto){
        return genreService.createGenre(createGenreDto);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGenre(@PathVariable long id){
        genreService.deleteGenreById(id);
    }

    @PatchMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenreResponseDto updateGenre(@Valid @RequestBody UpdateGenreDto updateGenreDto){
        return genreService.updateGenre(updateGenreDto);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenreResponseDto getGenreById(@PathVariable long id){
        return genreService.getGenreById(id);
    }

    @GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<GenreResponseDto> getGenreById(){
        return genreService.getGenres();
    }
}
