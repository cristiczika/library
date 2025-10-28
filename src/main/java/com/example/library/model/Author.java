package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private String id;
    private String name;
    private List<String> books;

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
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

    public List<String> getBooks() {
        return books;
    }

    public void addBook(String book) {
        books.add(book);
    }

}
