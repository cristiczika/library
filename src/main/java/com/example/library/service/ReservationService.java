package com.example.library.service;

import com.example.library.model.ReadableItem;
import com.example.library.model.Reservation;
import com.example.library.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void removeReservation(String reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId);
        if (reservation != null) {
            reservationRepository.delete(reservation);
        }
    }

    public Reservation getReservationById(String reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

}
