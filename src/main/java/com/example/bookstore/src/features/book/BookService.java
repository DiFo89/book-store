package com.example.bookstore.src.features.book;

import com.example.bookstore.src.features.author.AuthorRepository;
import com.example.bookstore.src.features.book.dto.BookResponseDto;
import com.example.bookstore.src.features.book.dto.CreateBookDto;
import com.example.bookstore.src.features.book.dto.UpdateBookDto;
import com.example.bookstore.src.features.book.entity.Book;
import com.example.bookstore.src.features.book.exceptions.BookNotFoundException;
import com.example.bookstore.src.features.genre.GenreRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    final BookRepository bookRepository;
    final BookMapper authorMapper;
    final AuthorRepository authorRepository;
    final GenreRepository genreRepository;

    BookService(BookRepository bookRepository, BookMapper authorMapper,AuthorRepository authorRepository, GenreRepository genreRepository){
        this.bookRepository = bookRepository;
        this.authorMapper = authorMapper;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public BookResponseDto createBook(CreateBookDto createBookDto){
        Book author = bookRepository.save(authorMapper.fromCreateDto(createBookDto, authorRepository.findAllById(createBookDto.authorIds()), genreRepository.findAllById(createBookDto.genreIds())));
        return authorMapper.toResponseEntity(author);
    }

    public void deleteBookById(long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        bookRepository.delete(book);
    }
    public BookResponseDto updateBook(UpdateBookDto updateBookDto){
        bookRepository.findById(updateBookDto.id()).orElseThrow(()->new BookNotFoundException(updateBookDto.id()));
        Book updatedBook = authorMapper.fromUpdateDto(updateBookDto,  authorRepository.findAllById(updateBookDto.authorIds()), genreRepository.findAllById(updateBookDto.genreIds()));
        final Book updateResult = bookRepository.save(updatedBook);
        return authorMapper.toResponseEntity(updateResult);
    }
    public BookResponseDto getBookById(long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        return authorMapper.toResponseEntity(book);
    }
    public List<BookResponseDto> getBooks(){
        List<Book> authors = bookRepository.findAll();
        return authors.stream().map(authorMapper::toResponseEntity).toList();
    }

}
