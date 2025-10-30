package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository extends InMemoryRepository<Reservation> {

    @Override
    protected String getId(Reservation reservation) {
        return reservation.getId();
    }

    @Override
    protected void setId(Reservation reservation, String id) {
        reservation.setId(id);
    }

}