package com.example.bookstore.src.features.book;

import com.example.bookstore.src.features.book.dto.BookResponseDto;
import com.example.bookstore.src.features.book.dto.CreateBookDto;
import com.example.bookstore.src.features.book.dto.UpdateBookDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto createBook(@Valid @RequestBody CreateBookDto createBookDto){
        return bookService.createBook(createBookDto);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable long id){
        bookService.deleteBookById(id);
    }

    @PatchMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookResponseDto updateBook(@Valid @RequestBody UpdateBookDto updateBookDto){
        return bookService.updateBook(updateBookDto);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookResponseDto getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }
    @GetMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponseDto> getBookById(){
        return bookService.getBooks();
    }
}
