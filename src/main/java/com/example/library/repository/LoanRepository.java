package com.example.library.repository;

import com.example.library.model.BookAuthor;
import com.example.library.model.BookDetails;
import com.example.library.model.Library;
import com.example.library.model.Loan;
import org.springframework.stereotype.Repository;

@Repository
public class LoanRepository extends InMemoryRepository<Loan> {

    @Override
    protected String getId(Loan author) {
        return author.getId();
    }

    @Override
    protected void setId(Loan author, String id) {
        author.setId(id);
    }

}