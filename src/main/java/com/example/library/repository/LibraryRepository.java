package com.example.library.repository;

import com.example.library.model.BookAuthor;
import com.example.library.model.BookDetails;
import com.example.library.model.Library;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository extends InMemoryRepository<Library> {

    @Override
    protected String getId(Library author) {
        return author.getId();
    }

    @Override
    protected void setId(Library author, String id) {
        author.setId(id);
    }

}