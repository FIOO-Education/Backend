package com.example.Fioo.Guardian;

import com.example.Fioo.Guardian.Model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    Optional<Guardian> getGuardianByEmail(String email);
}
