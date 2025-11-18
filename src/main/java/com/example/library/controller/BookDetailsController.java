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

    /*
    getAll si getById
     */
    @GetMapping
    public String getAllBookDetails(Model model) {
        model.addAttribute("bookdetails", bookDetailsService.getAllBookDetails());
        return "bookdetails/index";
    }

    @GetMapping("/{id}")
    public String getBookDetailsById(@PathVariable String id, Model model) {
        BookDetails bookDetails = bookDetailsService.getBookDetailsById(id);
        if (bookDetails == null) {
            return "redirect:/bookdetails";
        }

        model.addAttribute("bookdetail", bookDetails);
        return "bookdetails/details";
    }


    /*
    addBookDetails
    */
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


    /*
    updateBookDetails
    */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        BookDetails bookDetails = bookDetailsService.getBookDetailsById(id);
        if (bookDetails == null) {
            return "redirect:/bookdetails";
        }

        model.addAttribute("bookdetail", bookDetails);
        return "bookdetails/form";
    }

    @PostMapping("/{id}/edit")
    public String updateBookDetails(@PathVariable String id, @ModelAttribute BookDetails updated) {
        bookDetailsService.updateBookDetails(id, updated);
        return "redirect:/bookdetails";
    }


    /*
    deleteBookDetails
    */
    @PostMapping("/{id}/delete")
    public String deleteBookDetails(@PathVariable String id) {
        bookDetailsService.removeBookDetails(id);
        return "redirect:/bookdetails";
    }
}