package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String id;
    private String name;
    private List<BookDetails> books;

    public Author() {
        this.books = new ArrayList<>();
    }

    public Author(String id, String name) {
        this();
        this.id = id;
        this.name = name;
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

    public List<BookDetails> getBooks() {
        return books;
    }

    public void setBooks(List<BookDetails> books) {
        this.books = books;
    }

    public void addBook(BookDetails book) {
        if (book == null) {
            books = new ArrayList<>();
        }

        books.add(book);
    }
}
