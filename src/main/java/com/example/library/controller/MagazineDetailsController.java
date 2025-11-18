package com.example.library.controller;

import com.example.library.model.MagazineDetails;
import com.example.library.service.MagazineDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/magazinedetails")
public class MagazineDetailsController {

    private final MagazineDetailsService magazineDetailsService;

    public MagazineDetailsController(MagazineDetailsService magazineDetailsService) {
        this.magazineDetailsService = magazineDetailsService;
    }

    /*
    getAll si getById
    */
    @GetMapping
    public String getAllMagazineDetails(Model model) {
        model.addAttribute("magazinedetails", magazineDetailsService.getAllMagazineDetails());
        return "magazinedetails/index";
    }

    @GetMapping("/{id}")
    public String getMagazineDetailsById(@PathVariable String id, Model model) {
        MagazineDetails magazineDetails = magazineDetailsService.getMagazineDetailsById(id);
        if (magazineDetails == null) {
            return "redirect:/magazinedetails";
        }

        model.addAttribute("magazinedetail", magazineDetails);
        return "magazinedetails/details";
    }


    /*
    addMagazineDetails
    */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("magazinedetail", new MagazineDetails("", "", ""));
        return "magazinedetails/form";
    }

    @PostMapping
    public String addMagazineDetails(@ModelAttribute MagazineDetails magazineDetails) {
        magazineDetailsService.addMagazineDetails(magazineDetails);
        return "redirect:/magazinedetails";
    }


    /*
    updateMagazineDetails
    */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        MagazineDetails magazineDetails = magazineDetailsService.getMagazineDetailsById(id);
        if (magazineDetails == null) {
            return "redirect:/magazinedetails";
        }

        model.addAttribute("magazinedetail", magazineDetails);
        return "magazinedetails/form";
    }

    @PostMapping("/{id}/edit")
    public String updateMagazineDetails(@PathVariable String id, @ModelAttribute MagazineDetails updated) {
        magazineDetailsService.updateMagazineDetails(id, updated);
        return "redirect:/magazinedetails";
    }


    /*
    deleteMagazineDetails
    */
    @PostMapping("/{id}/delete")
    public String deleteMagazineDetails(@PathVariable String id) {
        magazineDetailsService.removeMagazineDetails(id);
        return "redirect:/magazinedetails";
    }
}