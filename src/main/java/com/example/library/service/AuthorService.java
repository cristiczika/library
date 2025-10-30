package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void removeAuthor(String authorId) {
        Author author = authorRepository.findById(authorId);
        if (author != null) {
            authorRepository.delete(author);
        }
    }

    public Author getAuthorById(String authorId) {
        return authorRepository.findById(authorId);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

}
