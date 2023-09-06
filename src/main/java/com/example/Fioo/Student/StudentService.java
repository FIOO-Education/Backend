package com.example.Fioo.Student;

import com.example.Fioo.Guardian.GuardianRepository;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Guardian.Dto.GuardianInsertDto;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository repo;
    private GuardianRepository gRepo;

    @Autowired
    public StudentService(StudentRepository studentRepository, GuardianRepository gRepo) {
        this.repo = studentRepository;
        this.gRepo = gRepo;
    }

    public ResponseEntity<String> registerUser(StudentInsertDto student, GuardianInsertDto guardian){
        try {
            repo.save(new Student(student));
            gRepo.save(new Guardian(guardian));
        } catch (Exception err) {
            throw err;
        }
        return ResponseEntity.ok("Aluno inserido com sucesso!");
    }
}
