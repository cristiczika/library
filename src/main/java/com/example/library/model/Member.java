package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String id;
    private String name;
    private String email;
    private String libraryId;
    private List<Reservation> reservations;
    private List<Loan> loans;

    public Member() {
        this.reservations = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public Member(String id, String name, String email, String libraryId) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
        this.libraryId = libraryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        if (reservations == null) {
            reservations = new ArrayList<>();
        }

        reservations.add(reservation);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan loan) {
        if (loans == null) {
            loans = new ArrayList<>();
        }

        loans.add(loan);
    }

}
