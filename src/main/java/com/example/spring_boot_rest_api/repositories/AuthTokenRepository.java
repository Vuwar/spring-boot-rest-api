package com.example.spring_boot_rest_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_boot_rest_api.entities.AuthToken;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {

    Optional<AuthToken> findByToken(String token);
}
