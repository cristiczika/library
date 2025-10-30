package com.example.library.controller;

import com.example.library.model.BookDetails;
import com.example.library.service.BookDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookdetails")
public class BookDetailsController {

    private final BookDetailsService bookDetailsService;

    public BookDetailsController(BookDetailsService bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping
    public String getAllBookDetails(Model model) {
        model.addAttribute("bookdetails", bookDetailsService.getAllBookDetails());
        return "bookdetails/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("bookdetail", new BookDetails("", ""));
        return "bookdetails/form";
    }

    @PostMapping
    public String addBookDetails(@ModelAttribute BookDetails bookDetails) {
        bookDetailsService.addBookDetails(bookDetails);
        return "redirect:/bookdetails";
    }

    @PostMapping("/{id}/delete")
    public String deleteBookDetails(@PathVariable String id) {
        bookDetailsService.removeBookDetails(id);
        return "redirect:/bookdetails";
    }
}