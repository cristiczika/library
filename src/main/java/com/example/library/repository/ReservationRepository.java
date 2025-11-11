package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository extends InFileRepository<Reservation> {

    public ReservationRepository() {
        super(Reservation.class, "reservations.json", "src/main/resources/data");
    }

    @Override
    protected String getId(Reservation reservation) {
        return reservation.getId();
    }

    @Override
    protected void setId(Reservation reservation, String id) {
        reservation.setId(id);
    }

}