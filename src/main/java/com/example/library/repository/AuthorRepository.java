package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    private final List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author("A1", "Mihai Eminescu", LocalDate.of(1850, 6, 15)),
            new Author("A2", "Ion Creanga", LocalDate.of(1837, 12, 12)),
            new Author("A3", "J. K. Rowling", LocalDate.of(1965, 2, 25)),
            new Author("A4", "Liviu Rebreanu", LocalDate.of(1885, 9, 9)),
            new Author("A5", "Camil Petrescu", LocalDate.of(1894, 7, 7))
    ));

    public List<Author> findAll() {
        return authors;
    }

    public Optional<Author> findById(String id) {
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public Author save(Author author) {
        authors.removeIf(a -> a.getId().equals(author.getId()));
        authors.add(author);
        return author;
    }

    public boolean deleteById(String id) {
        return authors.removeIf(a -> a.getId().equals(id));
    }
}