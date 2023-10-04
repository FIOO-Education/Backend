package com.example.Fioo.Student;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Guardian.GuardianRepository;
import com.example.Fioo.Guardian.GuardianService;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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

    public ApiResponse<Student> registerStudent(StudentInsertDto studentInsertDto){
        try {
            return new ApiResponse<>(200, "Success", new Student(studentInsertDto));
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(400, "Invalid request body :/", null);
        }

    }

    public ApiResponse<List<Student>> getStudents() {
        try {
            return new ApiResponse<>(200, "Success", repo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(500, "Internal Server Error", null);
        }
    }

    public Optional<Student> getStudentByEmail(String email) {
        Optional<Guardian> payload = guardianRepo.getGuardianByEmail(email);
        return Optional.of(repo.findStudentByCodGuardian(payload.get().getCodGuardian()));
    }
}
