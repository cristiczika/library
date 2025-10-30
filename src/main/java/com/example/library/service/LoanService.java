package com.example.library.service;

import com.example.library.model.Library;
import com.example.library.model.Loan;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void addLoan(Loan loan) {
        loanRepository.save(loan);
    }

    public void removeLoan(String loanId) {
        Loan loan = loanRepository.findById(loanId);
        if (loan != null) {
            loanRepository.delete(loan);
        }
    }

    public Loan getLoanById(String loanId) {
        return loanRepository.findById(loanId);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

}
