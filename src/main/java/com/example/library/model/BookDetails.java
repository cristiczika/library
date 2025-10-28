package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class BookDetails extends Publication {

    private List<BookAuthor> bookAuthors;

    public BookDetails(String id, String title) {
        super(id, title);
        this.bookAuthors = new ArrayList<>();
    }

    public List<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<BookAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public void addBookAuthor(BookAuthor bookAuthor) {
        if (bookAuthors == null) {
            bookAuthors = new ArrayList<>();
        }

        bookAuthors.add(bookAuthor);
    }

}