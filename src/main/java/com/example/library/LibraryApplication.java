package com.example.library;

import com.example.library.model.*;
import com.example.library.service.*;
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
    CommandLineRunner loadData(AuthorService authorService, BookAuthorService bookAuthorService, BookDetailsService bookDetailsService, LibraryService libraryService, LoanService loanService, MagazineDetailsService magazineDetailsService, MemberService memberService, ReadableItemService readableItemService, ReservationService reservationService) {
        return args -> {
//            authorService.addAuthor(new Author("A1", "Mihai Eminescu", LocalDate.of(1850, 6, 15)));
//            authorService.addAuthor(new Author("A2", "Ion Creanga", LocalDate.of(1837, 12, 12)));
//            authorService.addAuthor(new Author("A3", "J. K. Rowling", LocalDate.of(1965, 2, 25)));
//            authorService.addAuthor(new Author("A4", "Liviu Rebreanu", LocalDate.of(1885, 9, 9)));
//            authorService.addAuthor(new Author("A5", "Camil Petrescu", LocalDate.of(1894, 7, 7)));
//
//            bookAuthorService.addBookAuthor(new BookAuthor("BA1", "B1", "A1"));
//            bookAuthorService.addBookAuthor(new BookAuthor("BA2", "B2", "A2"));
//            bookAuthorService.addBookAuthor(new BookAuthor("BA3", "B3", "A3"));
//            bookAuthorService.addBookAuthor(new BookAuthor("BA4", "B4", "A4"));
//            bookAuthorService.addBookAuthor(new BookAuthor("BA5", "B5", "A5"));
//
//            bookDetailsService.addBookDetails(new BookDetails("B1", "Poezii"));
//            bookDetailsService.addBookDetails(new BookDetails("B2", "Amintiri din Copilarie"));
//            bookDetailsService.addBookDetails(new BookDetails("B3", "Harry Potter and the Sorcerer's Stone"));
//            bookDetailsService.addBookDetails(new BookDetails("B4", "Ion"));
//            bookDetailsService.addBookDetails(new BookDetails("B5", "Patul lui Procust"));
//
//            libraryService.addLibrary(new Library("L1", "Librarie Centru", "Strada Napoca 23"));
//
//            loanService.addLoan(new Loan("LN1", "M1", LocalDate.of(2025, 10, 20)));
//            loanService.addLoan(new Loan("LN2", "M2", LocalDate.of(2025, 10, 21)));
//
//            magazineDetailsService.addMagazineDetails(new MagazineDetails("M1", "National Geographic", "NatGeo"));
//            magazineDetailsService.addMagazineDetails(new MagazineDetails("M2", "Science Weekly", "The Guardian"));
//            magazineDetailsService.addMagazineDetails(new MagazineDetails("M3", "Time Magazine", "Time Inc."));
//
//            memberService.addMember(new Member("M1", "Ana Popescu", "ana.popescu@gmail.com", "L1"));
//            memberService.addMember(new Member("M2", "George Ionescu", "georgei@yahoo.com", "L1"));
//            memberService.addMember(new Member("M3", "Maria Dobre", "maria_dobre@gmail.com", "L1"));
//
//            readableItemService.addReadableItem(new ReadableItem("R1", "B1", "BC101", ReadableItemStatus.AVAILABLE));
//            readableItemService.addReadableItem(new ReadableItem("R2", "B2", "BC102", ReadableItemStatus.AVAILABLE));
//            readableItemService.addReadableItem(new ReadableItem("R3", "B3", "BC103", ReadableItemStatus.BORROWED));
//            readableItemService.addReadableItem(new ReadableItem("R4", "B4", "BC104", ReadableItemStatus.AVAILABLE));
//            readableItemService.addReadableItem(new ReadableItem("R5", "M1", "BC105", ReadableItemStatus.RESERVED));
//
//            reservationService.addReservation(new Reservation("RS1", "M1", "R5", "2025-10-25", ReservationStatus.ACTIVE));
//            reservationService.addReservation(new Reservation("RS2", "M2", "R3", "2025-10-26", ReservationStatus.COMPLETED));
        };
    }
}
