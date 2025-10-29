package com.example.library.service;

import com.example.library.model.Library;
import com.example.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library addLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public boolean removeLibrary(String libraryId) {
        return libraryRepository.deleteById(libraryId);
    }

    public Optional<Library> getLibraryById(String libraryId) {
        return libraryRepository.findById(libraryId);
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

}
