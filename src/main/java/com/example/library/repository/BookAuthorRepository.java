package com.example.library.repository;

import com.example.library.model.BookAuthor;
import org.springframework.stereotype.Repository;

@Repository
public class BookAuthorRepository extends InMemoryRepository<BookAuthor> {

    @Override
    protected String getId(BookAuthor bookAuthor) {
        return bookAuthor.getId();
    }

    @Override
    protected void setId(BookAuthor bookAuthor, String id) {
        bookAuthor.setId(id);
    }

}