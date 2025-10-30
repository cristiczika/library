package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class MagazineDetailsRepository extends InMemoryRepository<MagazineDetails> {

    @Override
    protected String getId(MagazineDetails author) {
        return author.getId();
    }

    @Override
    protected void setId(MagazineDetails author, String id) {
        author.setId(id);
    }

}