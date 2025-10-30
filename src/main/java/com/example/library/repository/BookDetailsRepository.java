package com.example.library.repository;

import com.example.library.model.BookAuthor;
import com.example.library.model.BookDetails;
import org.springframework.stereotype.Repository;

@Repository
public class BookDetailsRepository extends InMemoryRepository<BookDetails> {

    @Override
    protected String getId(BookDetails author) {
        return author.getId();
    }

    @Override
    protected void setId(BookDetails author, String id) {
        author.setId(id);
    }

}