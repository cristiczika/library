package com.example.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Author {

    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private List<BookDetails> books;

    public Author() {
        this.books = new ArrayList<>();
    }

    public Author(String id, String name, LocalDate dateOfBirth) {
        this();
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<BookDetails> getBooks() {
        return books;
    }

    public void setBooks(List<BookDetails> books) {
        this.books = books;
    }

    public void addBook(BookDetails book) {
        if (books == null) {
            books = new ArrayList<>();
        }

        books.add(book);
    }
}
