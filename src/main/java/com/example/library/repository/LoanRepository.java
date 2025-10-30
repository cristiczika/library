package com.example.library.repository;

import com.example.library.model.Loan;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class LoanRepository {

    private final List<Loan> loans = new ArrayList<>(Arrays.asList(
            new Loan("LN1", "M1", LocalDate.of(2025, 10, 20)),
            new Loan("LN2", "M2", LocalDate.of(2025, 10, 21))
    ));

    public List<Loan> findAll() {
        return loans;
    }

    public Optional<Loan> findById(String id) {
        return loans.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public Loan save(Loan loan) {
        loans.removeIf(l -> l.getId().equals(loan.getId()));
        loans.add(loan);
        return loan;
    }

    public boolean deleteById(String id) {
        return loans.removeIf(l -> l.getId().equals(id));
    }
}