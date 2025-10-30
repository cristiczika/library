package com.example.library.repository;

import com.example.library.model.BookAuthor;
import org.springframework.stereotype.Repository;

@Repository
public class BookAuthorRepository extends InMemoryRepository<BookAuthor> {

    @Override
    protected String getId(BookAuthor author) {
        return author.getId();
    }

    @Override
    protected void setId(BookAuthor author, String id) {
        author.setId(id);
    }

}