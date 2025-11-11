package com.example.library.repository;

import com.example.library.model.Author;
import com.example.library.model.Library;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository extends InFileRepository<Library> {

    public LibraryRepository() {
        super(Library.class, "libraries.json", "src/main/resources/data");
    }

    @Override
    protected String getId(Library library) {
        return library.getId();
    }

    @Override
    protected void setId(Library library, String id) {
        library.setId(id);
    }

}