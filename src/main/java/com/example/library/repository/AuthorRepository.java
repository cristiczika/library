package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends InFileRepository<Author> {

    public AuthorRepository() {
        super(Author.class, "authors.json", "src/main/resources/data");
    }

    @Override
    protected String getId(Author author) {
        return author.getId();
    }

    @Override
    protected void setId(Author author, String id) {
        author.setId(id);
    }
}