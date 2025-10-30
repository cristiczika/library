package com.example.library.service;

import com.example.library.model.BookDetails;
import com.example.library.repository.BookDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public void addBookDetails(BookDetails bookDetails) {
        bookDetailsRepository.save(bookDetails);
    }

    public void removeBookDetails(String bookDetailsId) {
        BookDetails bookDetails = bookDetailsRepository.findById(bookDetailsId);
        if (bookDetails != null) {
            bookDetailsRepository.delete(bookDetails);
        }
    }

    public BookDetails getBookDetailsById(String bookDetailsId) {
        return bookDetailsRepository.findById(bookDetailsId);
    }

    public List<BookDetails> getAllBookDetails() {
        return bookDetailsRepository.findAll();
    }

}
