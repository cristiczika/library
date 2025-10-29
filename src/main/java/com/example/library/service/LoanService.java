package com.example.library.service;

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

    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public boolean removeLoan(String loanId) {
        return loanRepository.deleteById(loanId);
    }

    public Optional<Loan> getLoanById(String loanId) {
        return loanRepository.findById(loanId);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

}
