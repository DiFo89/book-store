package com.example.bookstore.src.features.author;

import com.example.bookstore.src.features.author.dto.AuthorResponseDto;
import com.example.bookstore.src.features.author.dto.CreateAuthorDto;
import com.example.bookstore.src.features.author.dto.UpdateAuthorDto;
import com.example.bookstore.src.features.author.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author fromCreateDto(CreateAuthorDto createAuthorDto){
        Author author = new Author();

        author.setFirstName(createAuthorDto.firstName());
        author.setLastName(createAuthorDto.lastName());
        author.setSecondName(createAuthorDto.secondName());

        return author;
    }
    public Author fromUpdateDto(UpdateAuthorDto updateAuthorDto){
        Author author = new Author();

        author.setId(updateAuthorDto.id());
        author.setFirstName(updateAuthorDto.firstName());
        author.setLastName(updateAuthorDto.lastName());
        author.setSecondName(updateAuthorDto.secondName());

        return author;
    }
    public AuthorResponseDto toResponseEntity(Author author){
        return new AuthorResponseDto(author.getId(), author.getFirstName(), author.getLastName(), author.getSecondName());
    }
}
