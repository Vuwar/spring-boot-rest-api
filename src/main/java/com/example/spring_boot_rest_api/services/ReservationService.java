package com.example.spring_boot_rest_api.services;

import com.example.spring_boot_rest_api.entities.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    Reservation createReservation(Long customerId, Long workspaceId);
    List<Reservation> getReservationsByCustomer(Long customerId);
    List<Reservation> findReservationsWithinDateRange(LocalDateTime startTime, LocalDateTime endTime);
    void deleteExpiredReservations();
    List<Reservation> getReservationsByStatus(String status);
}
