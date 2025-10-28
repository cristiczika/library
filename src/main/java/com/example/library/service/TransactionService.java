package com.example.library.service;

import com.example.library.model.Loan;
import com.example.library.model.Reservation;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final LoanRepository loanRepo;
    private final ReservationRepository reservationRepo;

    public TransactionService(LoanRepository loanRepo, ReservationRepository reservationRepo) {
        this.loanRepo = loanRepo;
        this.reservationRepo = reservationRepo;
    }

    public List<Loan> getAllLoans() { return loanRepo.findAll(); }
    public Optional<Loan> getLoan(String id) { return loanRepo.findById(id); }
    public Loan addLoan(Loan l) { return loanRepo.save(l); }
    public boolean deleteLoan(String id) { return loanRepo.deleteById(id); }

    public List<Reservation> getAllReservations() { return reservationRepo.findAll(); }
    public Optional<Reservation> getReservation(String id) { return reservationRepo.findById(id); }
    public Reservation addReservation(Reservation r) { return reservationRepo.save(r); }
    public boolean deleteReservation(String id) { return reservationRepo.deleteById(id); }
}