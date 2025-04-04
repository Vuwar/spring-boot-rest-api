package com.example.spring_boot_rest_api.repositories;

import com.example.spring_boot_rest_api.entities.Customer;
import com.example.spring_boot_rest_api.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends GenericRepository<Reservation, Long> {
    List<Reservation> findByCustomer(Customer customer);
    void deleteByEndTimeBefore(LocalDateTime endTime);

    @Query("SELECT r FROM Reservation r WHERE r.startTime >= :startTime AND r.endTime <= :endTime")
    List<Reservation> findReservationsWithinDateRange(LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT r FROM Reservation r WHERE r.status = :status")
    List<Reservation> findByStatus(@Param("status") String status);
}
