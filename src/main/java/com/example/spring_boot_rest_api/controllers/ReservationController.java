package com.example.spring_boot_rest_api.controllers;

import com.example.spring_boot_rest_api.entities.Reservation;
import com.example.spring_boot_rest_api.services.impl.ReservationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@Tag(name = "Reservation Management", description = "Operations related to Reservations")
public class ReservationController {

    private final ReservationServiceImpl reservationServiceImpl;

    public ReservationController(ReservationServiceImpl reservationServiceImpl) {
        this.reservationServiceImpl = reservationServiceImpl;
    }

    @Operation(summary = "Create a new reservation")
    @PostMapping("/add")
    public Reservation createReservation(@RequestParam Long customerId,
                                         @RequestParam Long workspaceId) {
        return reservationServiceImpl.createReservation(customerId, workspaceId);
    }

    @Operation(summary = "Get a reservation based on customer ID")
    @GetMapping("/customer/{customerId}")
    public List<Reservation> getReservationsByCustomer(@PathVariable Long customerId) {
        return reservationServiceImpl.getReservationsByCustomer(customerId);
    }

    @Operation(summary = "Get reservations in certain date range")
    @GetMapping("/date-range")
    public List<Reservation> getReservationsWithinDateRange(
            @RequestParam LocalDateTime startTime,
            @RequestParam LocalDateTime endTime) {
        return reservationServiceImpl.findReservationsWithinDateRange(startTime, endTime);
    }

    @Operation(summary = "Get reservations based on its status")
    @GetMapping("/all")
    public List<Reservation> getReservations(@RequestParam(required = false) String status) {
        if (status != null) {
            return reservationServiceImpl.getReservationsByStatus(status);
        }
        return reservationServiceImpl.findAll();
    }


}
