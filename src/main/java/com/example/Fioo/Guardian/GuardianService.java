package com.example.Fioo.Guardian;

import com.example.Fioo.Guardian.Model.Guardian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Guard;

@Service
public class GuardianService {
    private GuardianRepository repo;

    @Autowired(required = false )
    public GuardianService(GuardianRepository guardianRepository) {
        this.repo = guardianRepository;
    }

    public ResponseEntity<Guardian> insertGuardian(Guardian guardian) {
        try {
           repo.save(guardian);
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(guardian);
        }
        return ResponseEntity.ok(guardian);
    }

    public ResponseEntity<Guardian> getGuardianByEmail(String email) {
        try {
            Guardian payload = repo.getGuardianByEmail(email);
            return ResponseEntity.ok(payload);
        } catch (Exception err) {
            return ResponseEntity.notFound().build();
        }
    }
}
