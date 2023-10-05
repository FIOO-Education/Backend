package com.example.Fioo.Guardian;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Guardian.Dto.PostGuardianDTO;
import com.example.Fioo.Guardian.Model.Guardian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuardianService {
    private GuardianRepository repo;

    @Autowired
    public GuardianService(GuardianRepository guardianRepository) {
        this.repo = guardianRepository;
    }
    public ApiResponse<Guardian> insertGuardian(PostGuardianDTO guardian) {
        Guardian payload = repo.save(new Guardian(guardian));
        return payload;
    }

    public Optional<Guardian> getGuardianByEmail(String email) {
        Optional<Guardian> payload = repo.getGuardianByEmail(email);
        return payload;
    }

    public List<Guardian> getAllGuardians() {
        return repo.findAll();
    }
}
