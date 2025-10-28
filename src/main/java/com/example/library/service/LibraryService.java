package com.example.library.service;

import com.example.library.model.BookDetails;
import com.example.library.model.MagazineDetails;
import com.example.library.model.ReadableItem;
import com.example.library.repository.BookDetailsRepository;
import com.example.library.repository.MagazineDetailsRepository;
import com.example.library.repository.ReadableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final BookDetailsRepository bookRepo;
    private final MagazineDetailsRepository magazineRepo;
    private final ReadableItemRepository itemRepo;

    public LibraryService(BookDetailsRepository bookRepo, MagazineDetailsRepository magazineRepo, ReadableItemRepository itemRepo) {
        this.bookRepo = bookRepo;
        this.magazineRepo = magazineRepo;
        this.itemRepo = itemRepo;
    }

    public List<BookDetails> getAllBooks() { return bookRepo.findAll(); }
    public Optional<BookDetails> getBook(String id) { return bookRepo.findById(id); }
    public BookDetails addBook(BookDetails b) { return bookRepo.save(b); }
    public boolean deleteBook(String id) { return bookRepo.deleteById(id); }

    public List<MagazineDetails> getAllMagazines() { return magazineRepo.findAll(); }
    public Optional<MagazineDetails> getMagazine(String id) { return magazineRepo.findById(id); }
    public MagazineDetails addMagazine(MagazineDetails m) { return magazineRepo.save(m); }
    public boolean deleteMagazine(String id) { return magazineRepo.deleteById(id); }

    public List<ReadableItem> getAllItems() { return itemRepo.findAll(); }
    public Optional<ReadableItem> getItem(String id) { return itemRepo.findById(id); }
    public ReadableItem addItem(ReadableItem i) { return itemRepo.save(i); }
    public boolean deleteItem(String id) { return itemRepo.deleteById(id); }
}