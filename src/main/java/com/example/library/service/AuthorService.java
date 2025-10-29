package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public boolean removeAuthor(String authorId) {
        return authorRepository.deleteById(authorId);
    }

    public Optional<Author> getAuthorById(String authorId) {
        return authorRepository.findById(authorId);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

}
