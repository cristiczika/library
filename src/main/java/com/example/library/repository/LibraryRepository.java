package com.example.library.repository;

import com.example.library.model.Library;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository {

    private final List<Library> libraries = new ArrayList<>(Arrays.asList(
            new Library("L1", "Librarie Centru")
    ));

    public List<Library> findAll() {
        return libraries;
    }

    public Optional<Library> findById(String id) {
        return libraries.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public Library save(Library library) {
        libraries.removeIf(l -> l.getId().equals(library.getId()));
        libraries.add(library);
        return library;
    }

    public boolean deleteById(String id) {
        return libraries.removeIf(l -> l.getId().equals(id));
    }
}