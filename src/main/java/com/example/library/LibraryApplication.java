package com.example.library;

import com.example.library.controller.AuthorController;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);

        addSampleData();
    }

    public static void addSampleData() {
        AuthorRepository authorRepository = new AuthorRepository();
        authorRepository.save(new Author("A1", "Mihai Eminescu", LocalDate.of(1850, 6, 15)));
        authorRepository.save(new Author("A2", "Ion Creanga", LocalDate.of(1837, 12, 12)));
        authorRepository.save(new Author("A3", "J. K. Rowling", LocalDate.of(1965, 2, 25)));
        authorRepository.save(new Author("A4", "Liviu Rebreanu", LocalDate.of(1885, 9, 9)));
        authorRepository.save(new Author("A5", "Camil Petrescu", LocalDate.of(1894, 7, 7)));
    }

}
