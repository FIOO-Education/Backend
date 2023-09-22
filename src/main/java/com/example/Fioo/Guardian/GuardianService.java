package com.example.Fioo.Guardian;

import com.example.Fioo.Guardian.Dto.GuardianInsertDto;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Model.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Guard;
import java.util.List;
import java.util.Optional;

@Service
public class GuardianService {
    private GuardianRepository repo;

    @Autowired(required = true )
    public GuardianService(GuardianRepository guardianRepository) {
        this.repo = guardianRepository;
    }

    public Guardian insertGuardian(GuardianInsertDto guardian) {
        System.out.println(guardian);
        System.out.println(new Guardian(guardian));
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
