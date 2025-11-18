package com.example.library.controller;

import com.example.library.model.Reservation;
import com.example.library.model.ReservationStatus;
import com.example.library.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /*
    getAll si getById
     */
    @GetMapping
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations/index";
    }

    @GetMapping("/{id}")
    public String getReservationById(@PathVariable String id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return "redirect:/reservations";
        }

        model.addAttribute("reservation", reservation);
        model.addAttribute("statuses", ReservationStatus.values());
        return "reservations/details";
    }


    /*
    addReservation
     */
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("reservation", new Reservation("", "", "", "", ReservationStatus.ACTIVE));
        model.addAttribute("statuses", ReservationStatus.values());
        return "reservations/form";
    }

    @PostMapping
    public String addReservation(@ModelAttribute Reservation reservation) {
        reservationService.addReservation(reservation);
        return "redirect:/reservations";
    }


    /*
    updateReservation
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return "redirect:/reservations";
        }

        model.addAttribute("reservation", reservation);
        model.addAttribute("statuses", ReservationStatus.values());
        return "reservations/form";
    }

    @PostMapping("/{id}/edit")
    public String updateReservation(@PathVariable String id, @ModelAttribute Reservation updated) {
        reservationService.updateReservation(id, updated);
        return "redirect:/reservations";
    }


    /*
    deleteReservation
     */
    @PostMapping("/{id}/delete")
    public String deleteReservation(@PathVariable String id) {
        reservationService.removeReservation(id);
        return "redirect:/reservations";
    }
}