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

    @GetMapping
    public String getAllLoans(Model model) {
        model.addAttribute("loans", loanService.getAllLoans());
        return "loans/index";
    }

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

    @PostMapping("/{id}/delete")
    public String deleteLoan(@PathVariable String id) {
        loanService.removeLoan(id);
        return "redirect:/loans";
    }
}