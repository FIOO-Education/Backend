package com.example.Fioo.Guardian;

import com.example.Fioo.Guardian.Model.Guardian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class GuardianService {
    private GuardianRepository repo;

    @Autowired(required = false )
    public GuardianService(GuardianRepository guardianRepository) {
        this.repo = guardianRepository;
    }

    public ResponseEntity<String> insertGuardian(Guardian guardian) {
        try {
           repo.save(guardian);
        } catch (Exception err) {
            throw err;
        }
        return ResponseEntity.ok("Guardião Inserido com sucesso!");
    }
}
