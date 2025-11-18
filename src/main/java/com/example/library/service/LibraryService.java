package com.example.library.service;

import com.example.library.model.Library;
import com.example.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void addLibrary(Library library) {
        libraryRepository.save(library);
    }

    public void updateLibrary(String id, Library update) {
        update.setId(id);
        libraryRepository.save(update);
    }

    public void removeLibrary(String libraryId) {
        Library library = libraryRepository.findById(libraryId);
        if (library != null) {
            libraryRepository.delete(library);
        }
    }

    public Library getLibraryById(String libraryId) {
        return libraryRepository.findById(libraryId);
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

}
