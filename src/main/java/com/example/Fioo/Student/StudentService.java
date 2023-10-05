package com.example.Fioo.Student;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Guardian.GuardianRepository;
import com.example.Fioo.Guardian.GuardianService;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.MessageRequest;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @Autowired
    public StudentService(StudentRepository studentRepository, GuardianRepository guardianService) {
        this.repo = studentRepository;
        this.guardianRepo = guardianService;
    }

    public ApiResponse<Student> registerStudent(StudentInsertDto studentInsertDto){
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), "Success", new Student(studentInsertDto));
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "Invalid request body :/", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
        }

    }

    public ApiResponse<List<Student>> getStudents() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), "Success", repo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", null);
        }
    }

    public ApiResponse<Student> getStudentByEmail(String email) {
        try {
            Optional<Guardian> payload = guardianRepo.getGuardianByEmail(email);
            if(payload.isPresent()) {
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.findStudentByCodGuardian(payload.get().getCodGuardian()));
            } else {
                return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.DATA_NOT_FOUND.getMessage(), null);
            }
        } catch (HttpClientErrorException.BadRequest e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MessageRequest.BAD_REQUEST.getMessage(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(), null);
        }
    }
}
