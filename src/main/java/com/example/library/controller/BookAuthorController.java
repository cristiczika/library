package com.example.library.controller;

import com.example.library.model.BookAuthor;
import com.example.library.service.BookAuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/bookauthors")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    public BookAuthorController(BookAuthorService bookAuthorService) {
        this.bookAuthorService = bookAuthorService;
    }

    @GetMapping
    public String getAllBookAuthors(Model model) {
        model.addAttribute("bookauthors", bookAuthorService.getAllBookAuthors());
        return "bookauthors/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("bookauthor", new BookAuthor("", "", ""));
        return "bookauthors/form";
    }

    @PostMapping
    public String addBookAuthor(@ModelAttribute BookAuthor bookAuthor) {
        bookAuthorService.addBookAuthor(bookAuthor);
        return "redirect:/bookauthors";
    }

    @PostMapping("/{id}/delete")
    public String deleteBookAuthor(@PathVariable String id) {
        bookAuthorService.removeBookAuthor(id);
        return "redirect:/bookauthors";
    }
}