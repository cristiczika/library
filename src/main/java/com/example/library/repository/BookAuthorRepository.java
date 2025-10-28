package com.example.library.repository;

import com.example.library.model.BookAuthor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class BookAuthorRepository {

    private final List<BookAuthor> bookAuthors = new ArrayList<>(Arrays.asList(
            new BookAuthor("BA1", "B1", "A1"),
            new BookAuthor("BA2", "B2", "A2"),
            new BookAuthor("BA3", "B3", "A3"),
            new BookAuthor("BA4", "B4", "A4"),
            new BookAuthor("BA5", "B5", "A5")
    ));

    public List<BookAuthor> findAll() {
        return bookAuthors;
    }

    public Optional<BookAuthor> findById(String id) {
        return bookAuthors.stream().filter(ba -> ba.getId().equals(id)).findFirst();
    }

    public BookAuthor save(BookAuthor bookAuthor) {
        bookAuthors.removeIf(ba -> ba.getId().equals(bookAuthor.getId()));
        bookAuthors.add(bookAuthor);
        return bookAuthor;
    }

    public boolean deleteById(String id) {
        return bookAuthors.removeIf(ba -> ba.getId().equals(id));
    }
}