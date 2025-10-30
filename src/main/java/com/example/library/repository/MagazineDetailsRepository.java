package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class MagazineDetailsRepository extends InMemoryRepository<MagazineDetails> {

    @Override
    protected String getId(MagazineDetails magazineDetails) {
        return magazineDetails.getId();
    }

    @Override
    protected void setId(MagazineDetails magazineDetails, String id) {
        magazineDetails.setId(id);
    }

}