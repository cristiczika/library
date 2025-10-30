package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends InMemoryRepository<Author> {

    @Override
    protected String getId(Author author) {
        return author.getId();
    }

    @Override
    protected void setId(Author author, String id) {
        author.setId(id);
    }

}