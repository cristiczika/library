package com.example.library.controller;

import com.example.library.model.Library;
import com.example.library.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String getAllLibraries(Model model) {
        model.addAttribute("libraries", libraryService.getAllLibraries());
        return "libraries/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("library", new Library("", "", ""));
        return "libraries/form";
    }

    @PostMapping
    public String addLibrary(@ModelAttribute Library library) {
        libraryService.addLibrary(library);
        return "redirect:/libraries";
    }

    @PostMapping("/{id}/delete")
    public String deleteLibrary(@PathVariable String id) {
        libraryService.removeLibrary(id);
        return "redirect:/libraries";
    }
}