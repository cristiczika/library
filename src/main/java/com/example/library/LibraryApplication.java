package com.example.library;

import com.example.library.model.Author;
import com.example.library.model.BookAuthor;
import com.example.library.model.BookDetails;
import com.example.library.model.Library;
import com.example.library.service.AuthorService;
import com.example.library.service.BookAuthorService;
import com.example.library.service.BookDetailsService;
import com.example.library.service.LibraryService;
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
    CommandLineRunner loadData(AuthorService authorService, BookAuthorService bookAuthorService, BookDetailsService bookDetailsService, LibraryService libraryService) {
        return args -> {
            authorService.addAuthor(new Author("A1", "Mihai Eminescu", LocalDate.of(1850, 6, 15)));
            authorService.addAuthor(new Author("A2", "Ion Creanga", LocalDate.of(1837, 12, 12)));
            authorService.addAuthor(new Author("A3", "J. K. Rowling", LocalDate.of(1965, 2, 25)));
            authorService.addAuthor(new Author("A4", "Liviu Rebreanu", LocalDate.of(1885, 9, 9)));
            authorService.addAuthor(new Author("A5", "Camil Petrescu", LocalDate.of(1894, 7, 7)));

            bookAuthorService.addBookAuthor(new BookAuthor("BA1", "B1", "A1"));
            bookAuthorService.addBookAuthor(new BookAuthor("BA2", "B2", "A2"));
            bookAuthorService.addBookAuthor(new BookAuthor("BA3", "B3", "A3"));
            bookAuthorService.addBookAuthor(new BookAuthor("BA4", "B4", "A4"));
            bookAuthorService.addBookAuthor(new BookAuthor("BA5", "B5", "A5"));

            bookDetailsService.addBookDetails(new BookDetails("B1", "Poezii"));
            bookDetailsService.addBookDetails(new BookDetails("B2", "Amintiri din Copilarie"));
            bookDetailsService.addBookDetails(new BookDetails("B3", "Harry Potter and the Sorcerer's Stone"));
            bookDetailsService.addBookDetails(new BookDetails("B4", "Ion"));
            bookDetailsService.addBookDetails(new BookDetails("B5", "Patul lui Procust"));

            libraryService.addLibrary(new Library("L1", "Librarie Centru", "Strada Napoca 23"));
        };
    }
}
