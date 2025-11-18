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

    /*
    getAll si getById
     */
    @GetMapping
    public String getAllBookAuthors(Model model) {
        model.addAttribute("bookauthors", bookAuthorService.getAllBookAuthors());
        return "bookauthors/index";
    }

    @GetMapping("/{id}")
    public String getBookAuthorById(@PathVariable String id, Model model) {
        BookAuthor bookAuthor = bookAuthorService.getBookAuthorById(id);
        if (bookAuthor == null) {
            return "redirect:/bookauthors";
        }

        model.addAttribute("bookauthor", bookAuthor);
        return "bookauthors/details";
    }


    /*
    addBookAuthor
     */
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


    /*
    updateBookAuthor
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        BookAuthor bookAuthor = bookAuthorService.getBookAuthorById(id);
        if (bookAuthor == null) {
            return "redirect:/bookauthors";
        }

        model.addAttribute("bookauthor", bookAuthor);
        return "bookauthors/form";
    }

    @PostMapping("/{id}/edit")
    public String updateBookAuthor(@PathVariable String id, @ModelAttribute BookAuthor bookAuthor) {
        bookAuthorService.updateBookAuthor(id, bookAuthor);
        return "redirect:/bookauthors";
    }


    /*
    deleteBookAuthor
     */
    @PostMapping("/{id}/delete")
    public String deleteBookAuthor(@PathVariable String id) {
        bookAuthorService.removeBookAuthor(id);
        return "redirect:/bookauthors";
    }
}