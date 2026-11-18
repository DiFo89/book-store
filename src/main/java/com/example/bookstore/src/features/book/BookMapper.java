package com.example.bookstore.src.features.book;

import com.example.bookstore.src.features.author.entity.Author;
import com.example.bookstore.src.features.book.dto.BookResponseDto;
import com.example.bookstore.src.features.book.dto.CreateBookDto;
import com.example.bookstore.src.features.book.dto.UpdateBookDto;
import com.example.bookstore.src.features.book.entity.Book;
import com.example.bookstore.src.features.genre.entity.Genre;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {
    public Book fromCreateDto(CreateBookDto createBookDto, List<Author> authors, List<Genre> genres){
        Book book = new Book();

        book.setTitle(createBookDto.title());
        book.setAuthors(authors);
        book.setGenres(genres);

        return book;
    }
    public Book fromUpdateDto(UpdateBookDto updateBookDto,List<Author> authors, List<Genre> genres){
        Book book = new Book();

        book.setId(updateBookDto.id());
        book.setTitle(updateBookDto.title());
        book.setAuthors(authors);
        book.setGenres(genres);

        return book;
    }
    public BookResponseDto toResponseEntity(Book book){
        return new BookResponseDto(book.getId(), book.getTitle(), book.getAuthors(), book.getGenres());
    }
}
