package com.example.library.repository;

import com.example.library.model.BookAuthor;
import com.example.library.model.BookDetails;
import com.example.library.model.Library;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository extends InMemoryRepository<Library> {

    @Override
    protected String getId(Library library) {
        return library.getId();
    }

    @Override
    protected void setId(Library library, String id) {
        library.setId(id);
    }

}