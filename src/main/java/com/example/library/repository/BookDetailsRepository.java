package com.example.library.repository;

import com.example.library.model.BookDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDetailsRepository {

    private final List<BookDetails> books = new ArrayList<>(Arrays.asList(
            new BookDetails("B1", "Poezii"),
            new BookDetails("B2", "Amintiri din Copilarie"),
            new BookDetails("B3", "Harry Potter and the Sorcerer’s Stone"),
            new BookDetails("B4", "Ion"),
            new BookDetails("B5", "Patul lui Procust")
    ));

    public List<BookDetails> findAll() {
        return books;
    }

    public Optional<BookDetails> findById(String id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public BookDetails save(BookDetails book) {
        books.removeIf(b -> b.getId().equals(book.getId()));
        books.add(book);
        return book;
    }

    public boolean deleteById(String id) {
        return books.removeIf(b -> b.getId().equals(id));
    }
}