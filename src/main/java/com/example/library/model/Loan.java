package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

public class Loan {

    private String id;
    private String memberId;
    private String date;
    private List<Reservation> reservations;
    private List<ReadableItem> items;

    public Loan() {
        this.reservations = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public Loan(String id, String memberId, String date) {
        this();
        this.id = id;
        this.memberId = memberId;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public List<ReadableItem> getItems() {
        return items;
    }

    public void setItems(List<ReadableItem> items) {
        this.items = items;
    }

    public void addItem(ReadableItem item) {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(item);
    }

}
