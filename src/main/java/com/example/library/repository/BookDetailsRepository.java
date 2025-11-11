package com.example.library.repository;

import com.example.library.model.BookDetails;
import org.springframework.stereotype.Repository;

@Repository
public class BookDetailsRepository extends InFileRepository<BookDetails> {

    public BookDetailsRepository() {
        super(BookDetails.class, "bookdetails.json", "src/main/resources/data");
    }

    @Override
    protected String getId(BookDetails bookDetails) {
        return bookDetails.getId();
    }

    @Override
    protected void setId(BookDetails bookDetails, String id) {
        bookDetails.setId(id);
    }

}