package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {

    private final List<Author> authors = new ArrayList<>(Arrays.asList(
            new Author("A1", "Mihai Eminescu"),
            new Author("A2", "Ion Creanga"),
            new Author("A3", "J. K. Rowling"),
            new Author("A4", "Liviu Rebreanu"),
            new Author("A5", "Camil Petrescu")
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