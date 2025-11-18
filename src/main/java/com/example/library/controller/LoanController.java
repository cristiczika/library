package com.example.library.controller;

import com.example.library.model.Loan;
import com.example.library.service.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    /*
    getAll si getById
     */
    @GetMapping
    public String getAllLoans(Model model) {
        model.addAttribute("loans", loanService.getAllLoans());
        return "loans/index";
    }

    @GetMapping("/{id}")
    public String getLoanById(@PathVariable String id, Model model) {
        Loan loan = loanService.getLoanById(id);
        if (loan == null) {
            return "redirect:/loans";
        }

        model.addAttribute("loan", loan);
        return "loans/details";
    }


    /*
    addLoan
     */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("loan", new Loan("", "", LocalDate.now()));
        return "loans/form";
    }

    @PostMapping
    public String addLoan(@ModelAttribute Loan loan) {
        loanService.addLoan(loan);
        return "redirect:/loans";
    }


    /*
    updateLoan
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Loan loan = loanService.getLoanById(id);
        if (loan == null) {
            return "redirect:/loans";
        }

        model.addAttribute("loan", loan);
        return "loans/form";
    }

    @PostMapping("/{id}/edit")
    public String updateLoan(@PathVariable String id, @ModelAttribute Loan updatedLoan) {

        loanService.updateLoan(id, updatedLoan);
        return "redirect:/loans";
    }


    /*
    deleteLoan
     */
    @PostMapping("/{id}/delete")
    public String deleteLoan(@PathVariable String id) {
        loanService.removeLoan(id);
        return "redirect:/loans";
    }
}