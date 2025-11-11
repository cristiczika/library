package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class LoanRepository extends InFileRepository<Loan> {

    public LoanRepository() {
        super(Loan.class, "loans.json", "src/main/resources/data");
    }

    @Override
    protected String getId(Loan loan) {
        return loan.getId();
    }

    @Override
    protected void setId(Loan loan, String id) {
        loan.setId(id);
    }

}