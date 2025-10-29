package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String id;
    private String name;
    private int birthYear;
    private List<BookDetails> books;

    public Author() {
        this.books = new ArrayList<>();
    }

    public Author(String id, String name, int birthYear) {
        this();
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
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
