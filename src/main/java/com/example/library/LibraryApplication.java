package com.example.library;

import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(AuthorService authorService) {
        return args -> {
            authorService.addAuthor(new Author("A1", "Mihai Eminescu", LocalDate.of(1850, 6, 15)));
            authorService.addAuthor(new Author("A2", "Ion Creanga", LocalDate.of(1837, 12, 12)));
            authorService.addAuthor(new Author("A3", "J. K. Rowling", LocalDate.of(1965, 2, 25)));
            authorService.addAuthor(new Author("A4", "Liviu Rebreanu", LocalDate.of(1885, 9, 9)));
            authorService.addAuthor(new Author("A5", "Camil Petrescu", LocalDate.of(1894, 7, 7)));
        };
    }
}
