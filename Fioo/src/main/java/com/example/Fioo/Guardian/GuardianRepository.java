package com.example.Fioo.Guardian;

import com.example.Fioo.Guardian.Model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}
