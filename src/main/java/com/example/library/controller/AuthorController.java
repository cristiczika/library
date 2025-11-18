package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /*
    getAll si getById
     */
    @GetMapping
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors/index";
    }

    @GetMapping("/{id}")
    public String getAuthorById(@PathVariable String id, Model model) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            return "redirect:/authors";
        }

        model.addAttribute("author", author);
        return "authors/details";
    }

    /*
    addAuthor
     */
    @PostMapping
    public String addAuthor(@ModelAttribute Author author) {
        authorService.addAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("author", new Author("", "", LocalDate.now()));
        return "authors/form";
    }


    /*
    updateAuthor
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Author author = authorService.getAuthorById(id);
        if (author == null) {
            return "redirect:/authors";
        }

        model.addAttribute("author", author);
        return "authors/form";
    }

    @PostMapping("/{id}/edit")
    public String updateAuthor(@PathVariable String id, @ModelAttribute Author author) {
        authorService.updateAuthor(id, author);
        return "redirect:/authors";
    }


    /*
    deleteAuthor
     */
    @PostMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable String id) {
        authorService.removeAuthor(id);
        return "redirect:/authors";
    }
}