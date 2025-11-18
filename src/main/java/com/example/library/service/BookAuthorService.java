package com.example.library.service;

import com.example.library.model.BookAuthor;
import com.example.library.repository.BookAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public void addBookAuthor(BookAuthor bookAuthor) {
        bookAuthorRepository.save(bookAuthor);
    }

    public void updateBookAuthor(String id, BookAuthor update) {
        update.setId(id);
        bookAuthorRepository.save(update);
    }

    public void removeBookAuthor(String bookAuthorId) {
        BookAuthor bookAuthor = bookAuthorRepository.findById(bookAuthorId);
        if (bookAuthor != null) {
            bookAuthorRepository.delete(bookAuthor);
        }
    }

    public BookAuthor getBookAuthorById(String bookAuthorId) {
        return bookAuthorRepository.findById(bookAuthorId);
    }

    public List<BookAuthor> getAllBookAuthors() {
        return bookAuthorRepository.findAll();
    }

}
