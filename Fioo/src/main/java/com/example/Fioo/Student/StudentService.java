package com.example.Fioo.Student;

import com.example.Fioo.Guardian.GuardianRepository;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Guard;

@Service
public class StudentService {
    private StudentRepository repo;
    private GuardianRepository gRepo;

    @Autowired
    public StudentService(StudentRepository studentRepository, GuardianRepository gRepo) {
        this.repo = studentRepository;
        this.gRepo = gRepo;
    }

    public ResponseEntity<String> registerUser(Student student, Guardian guardian){
        try {
            repo.save(student);
            gRepo.save(guardian);
        } catch (Exception err) {
            throw err;
        }
        return ResponseEntity.ok("Aluno inserido com sucesso!");
    }
}
