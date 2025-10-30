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

    @GetMapping
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("reservation", new Reservation("", "", "", "", ReservationStatus.ACTIVE));
        return "reservations/form";
    }

    @PostMapping
    public String addReservation(@ModelAttribute Reservation reservation) {
        reservationService.addReservation(reservation);
        return "redirect:/reservations";
    }

    @PostMapping("/{id}/delete")
    public String deleteReservation(@PathVariable String id) {
        reservationService.removeReservation(id);
        return "redirect:/reservations";
    }
}