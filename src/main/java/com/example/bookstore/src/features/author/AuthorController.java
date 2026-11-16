package com.example.bookstore.src.features.author;

import com.example.bookstore.src.features.author.dto.AuthorResponseDto;
import com.example.bookstore.src.features.author.dto.CreateAuthorDto;
import com.example.bookstore.src.features.author.dto.UpdateAuthorDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDto createAuthor(@Valid @RequestBody CreateAuthorDto createAuthorDto){
        return authorService.createAuthor(createAuthorDto);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable long id){
        authorService.deleteAuthorById(id);
    }

    @PatchMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthorResponseDto updateAuthor(@Valid @RequestBody UpdateAuthorDto updateAuthorDto){
        return authorService.updateAuthor(updateAuthorDto);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AuthorResponseDto getAuthorById(@PathVariable long id){
        return authorService.getAuthorById(id);
    }
    @GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorResponseDto> getAuthorById(){
        return authorService.getAuthors();
    }
}
