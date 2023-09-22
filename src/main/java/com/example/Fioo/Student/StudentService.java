package com.example.Fioo.Student;

import com.example.Fioo.Guardian.GuardianRepository;
import com.example.Fioo.Guardian.GuardianService;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Guard;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository repo;
    private GuardianRepository guardianRepo;

    @Autowired(required = true)
    public StudentService(StudentRepository studentRepository, GuardianRepository guardianService) {
        this.repo = studentRepository;
        this.guardianRepo = guardianService;
    }

    public Student registerStudent(StudentInsertDto studentInsertDto){
        Student payload = repo.save(new Student(studentInsertDto));
        return payload;
    }

    public List<Student> getStudents() {
        List<Student> students = repo.findAll();
        return students;
    }

    public Optional<Student> getStudentByEmail(String email) {
        Optional<Guardian> payload = guardianRepo.getGuardianByEmail(email);
        Guardian guardian = payload.get();
        return Optional.of(repo.findStudentByCodGuardian(guardian.getCodGuardian()));
    }
}
