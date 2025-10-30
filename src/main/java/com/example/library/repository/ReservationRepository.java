package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository extends InMemoryRepository<Reservation> {

    @Override
    protected String getId(Reservation author) {
        return author.getId();
    }

    @Override
    protected void setId(Reservation author, String id) {
        author.setId(id);
    }

}