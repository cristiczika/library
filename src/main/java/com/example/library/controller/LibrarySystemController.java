package com.example.library.controller;

import com.example.library.model.*;
import com.example.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibrarySystemController {

    private final LibraryService libraryService;
    private final PeopleService peopleService;
    private final TransactionService transactionService;
    private final AdminService adminService;

    @Autowired
    public LibrarySystemController(LibraryService libraryService,
                                   PeopleService peopleService,
                                   TransactionService transactionService,
                                   AdminService adminService) {
        this.libraryService = libraryService;
        this.peopleService = peopleService;
        this.transactionService = transactionService;
        this.adminService = adminService;
    }

    @GetMapping("/books")
    public List<BookDetails> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<BookDetails> getBook(@PathVariable String id) {
        return libraryService.getBook(id);
    }

    @PostMapping("/books")
    public BookDetails addBook(@RequestBody BookDetails book) {
        return libraryService.addBook(book);
    }

    @GetMapping("/magazines")
    public List<MagazineDetails> getAllMagazines() {
        return libraryService.getAllMagazines();
    }

    @GetMapping("/magazines/{id}")
    public Optional<MagazineDetails> getMagazine(@PathVariable String id) {
        return libraryService.getMagazine(id);
    }

    @PostMapping("/magazines")
    public MagazineDetails addMagazine(@RequestBody MagazineDetails magazine) {
        return libraryService.addMagazine(magazine);
    }

    @GetMapping("/items")
    public List<ReadableItem> getAllItems() {
        return libraryService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Optional<ReadableItem> getItem(@PathVariable String id) {
        return libraryService.getItem(id);
    }

    @PostMapping("/items")
    public ReadableItem addItem(@RequestBody ReadableItem item) {
        return libraryService.addItem(item);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return peopleService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> getAuthor(@PathVariable String id) {
        return peopleService.getAuthor(id);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return peopleService.addAuthor(author);
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return peopleService.getAllMembers();
    }

    @GetMapping("/members/{id}")
    public Optional<Member> getMember(@PathVariable String id) {
        return peopleService.getMember(id);
    }

    @PostMapping("/members")
    public Member addMember(@RequestBody Member member) {
        return peopleService.addMember(member);
    }

    @GetMapping("/loans")
    public List<Loan> getAllLoans() {
        return transactionService.getAllLoans();
    }

    @GetMapping("/loans/{id}")
    public Optional<Loan> getLoan(@PathVariable String id) {
        return transactionService.getLoan(id);
    }

    @PostMapping("/loans")
    public Loan addLoan(@RequestBody Loan loan) {
        return transactionService.addLoan(loan);
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return transactionService.getAllReservations();
    }

    @GetMapping("/reservations/{id}")
    public Optional<Reservation> getReservation(@PathVariable String id) {
        return transactionService.getReservation(id);
    }

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return transactionService.addReservation(reservation);
    }

    @GetMapping("/branches")
    public List<Library> getAllLibraries() {
        return adminService.getAllLibraries();
    }

    @GetMapping("/branches/{id}")
    public Optional<Library> getLibrary(@PathVariable String id) {
        return adminService.getLibrary(id);
    }

    @PostMapping("/branches")
    public Library addLibrary(@RequestBody Library library) {
        return adminService.addLibrary(library);
    }
}