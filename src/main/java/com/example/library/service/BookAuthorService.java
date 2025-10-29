package com.example.library.service;

import com.example.library.model.BookAuthor;
import com.example.library.repository.BookAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public BookAuthor addBookAuthor(BookAuthor bookAuthor) {
        return bookAuthorRepository.save(bookAuthor);
    }

    public boolean removeBookAuthor(String bookAuthorId) {
        return bookAuthorRepository.deleteById(bookAuthorId);
    }

    public Optional<BookAuthor> getBookAuthorById(String bookAuthorId) {
        return bookAuthorRepository.findById(bookAuthorId);
    }

    public List<BookAuthor> getAllBookAuthors() {
        return bookAuthorRepository.findAll();
    }

}
