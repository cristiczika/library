package com.example.library.repository;

import com.example.library.model.Reservation;
import com.example.library.model.ReservationStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    private final List<Reservation> reservations = new ArrayList<>(Arrays.asList(
            new Reservation("RS1", "M1", "R5", "2025-10-25", ReservationStatus.ACTIVE),
            new Reservation("RS2", "M2", "R3", "2025-10-26", ReservationStatus.COMPLETED)
    ));

    public List<Reservation> findAll() {
        return reservations;
    }

    public Optional<Reservation> findById(String id) {
        return reservations.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public Reservation save(Reservation reservation) {
        reservations.removeIf(r -> r.getId().equals(reservation.getId()));
        reservations.add(reservation);
        return reservation;
    }

    public boolean deleteById(String id) {
        return reservations.removeIf(r -> r.getId().equals(id));
    }
}