package com.example.library.service;

import com.example.library.model.Library;
import com.example.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final LibraryRepository libraryRepo;

    public AdminService(LibraryRepository libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    public List<Library> getAllLibraries() { return libraryRepo.findAll(); }
    public Optional<Library> getLibrary(String id) { return libraryRepo.findById(id); }
    public Library addLibrary(Library l) { return libraryRepo.save(l); }
    public boolean deleteLibrary(String id) { return libraryRepo.deleteById(id); }
}