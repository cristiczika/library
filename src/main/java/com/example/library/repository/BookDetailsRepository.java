package com.example.library.repository;

import com.example.library.model.BookDetails;
import com.example.library.model.BookAuthor;
import com.example.library.model.ReadableItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDetailsRepository {

    private final List<BookDetails> books = new ArrayList<>(Arrays.asList(
            new BookDetails("B1", "Poezii", new ArrayList<>(), Arrays.asList(new BookAuthor("BA1", "B1", "A1"))),
            new BookDetails("B2", "Amintiri din Copilarie", new ArrayList<>(), Arrays.asList(new BookAuthor("BA2", "B2", "A2"))),
            new BookDetails("B3", "Harry Potter and the Sorcerer’s Stone", new ArrayList<>(), Arrays.asList(new BookAuthor("BA3", "B3", "A3"))),
            new BookDetails("B4", "Ion", new ArrayList<>(), Arrays.asList(new BookAuthor("BA4", "B4", "A4"))),
            new BookDetails("B5", "Patul lui Procust", new ArrayList<>(), Arrays.asList(new BookAuthor("BA5", "B5", "A5")))
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