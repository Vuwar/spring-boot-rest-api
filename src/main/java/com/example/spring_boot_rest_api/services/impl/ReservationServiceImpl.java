package com.example.spring_boot_rest_api.services.impl;

import com.example.spring_boot_rest_api.exceptions.EntityNotFoundException;
import com.example.spring_boot_rest_api.exceptions.InvalidRequestException;
import com.example.spring_boot_rest_api.entities.Customer;
import com.example.spring_boot_rest_api.entities.Reservation;
import com.example.spring_boot_rest_api.entities.Workspace;
import com.example.spring_boot_rest_api.repositories.CustomerRepository;
import com.example.spring_boot_rest_api.repositories.ReservationRepository;
import com.example.spring_boot_rest_api.repositories.WorkspaceRepository;
import com.example.spring_boot_rest_api.services.ReservationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceImpl extends GenericServiceImpl<Reservation, Long> implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        super(reservationRepository);
        this.reservationRepository = reservationRepository;
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Transactional
    public Reservation createReservation(Long customerId, Long workspaceId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new EntityNotFoundException("Workspace not found"));

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setWorkspace(workspace);

        return reservationRepository.save(reservation);
    }

    @Transactional
    public List<Reservation> getReservationsByCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        return reservationRepository.findByCustomer(customer);
    }

    @Transactional
    public List<Reservation> findReservationsWithinDateRange(LocalDateTime startTime, LocalDateTime endTime) {
        return reservationRepository.findReservationsWithinDateRange(startTime, endTime);
    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void deleteExpiredReservations() {
        LocalDateTime now = LocalDateTime.now();
        reservationRepository.deleteByEndTimeBefore(now);
        System.out.println("Expired reservations deleted at " + now);
    }

    @Transactional
    public List<Reservation> getReservationsByStatus(String status) {
        if (status == null || status.isEmpty()) {
            throw new InvalidRequestException("Reservation status cannot be empty");
        }
        return reservationRepository.findByStatus(status);
    }
}
