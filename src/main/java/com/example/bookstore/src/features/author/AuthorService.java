package com.example.bookstore.src.features.author;

import com.example.bookstore.src.features.author.dto.AuthorResponseDto;
import com.example.bookstore.src.features.author.dto.CreateAuthorDto;
import com.example.bookstore.src.features.author.dto.UpdateAuthorDto;
import com.example.bookstore.src.features.author.entity.Author;
import com.example.bookstore.src.features.author.exceptions.AuthorNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    final AuthorRepository authorRepository;
    final AuthorMapper authorMapper;

    AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper){
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Transactional
    public AuthorResponseDto createAuthor(CreateAuthorDto createAuthorDto){
        Author author = authorRepository.save(authorMapper.fromCreateDto(createAuthorDto));
        return authorMapper.toResponseEntity(author);
    }

    public void deleteAuthorById(long id){
        Author user = authorRepository.findById(id).orElseThrow(()->new AuthorNotFoundException(id));
        authorRepository.delete(user);
    }
    public AuthorResponseDto updateAuthor(UpdateAuthorDto updateAuthorDto){
        authorRepository.findById(updateAuthorDto.id()).orElseThrow(()->new AuthorNotFoundException(updateAuthorDto.id()));
        Author updatedAuthor = authorMapper.fromUpdateDto(updateAuthorDto);
        final Author updateResult = authorRepository.save(updatedAuthor);
        return authorMapper.toResponseEntity(updateResult);
    }
    public AuthorResponseDto getAuthorById(long id){
        Author user = authorRepository.findById(id).orElseThrow(()->new AuthorNotFoundException(id));
        return authorMapper.toResponseEntity(user);
    }
    public List<AuthorResponseDto> getAuthors(){
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(authorMapper::toResponseEntity).toList();
    }

}
