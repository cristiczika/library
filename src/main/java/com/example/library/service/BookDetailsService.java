package com.example.library.service;

import com.example.library.model.BookDetails;
import com.example.library.repository.BookDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public BookDetails addBookDetails(BookDetails bookDetails) {
        return bookDetailsRepository.save(bookDetails);
    }

    public boolean removeBookDetails(String bookDetailsId) {
        return bookDetailsRepository.deleteById(bookDetailsId);
    }

    public Optional<BookDetails> getBookDetailsById(String bookDetailsId) {
        return bookDetailsRepository.findById(bookDetailsId);
    }

    public List<BookDetails> getAllBookDetails() {
        return bookDetailsRepository.findAll();
    }

}
