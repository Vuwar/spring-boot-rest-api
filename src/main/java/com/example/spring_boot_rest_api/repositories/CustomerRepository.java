package com.example.spring_boot_rest_api.repositories;

import com.example.spring_boot_rest_api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends GenericRepository<Customer, Long> {
}
