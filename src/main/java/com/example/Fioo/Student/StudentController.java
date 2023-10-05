package com.example.Fioo.Student;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Guardian.GuardianService;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Guard;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(
            StudentService studentService
    ) {
        this.studentService = studentService;
    }
    @PostMapping
    public ApiResponse<Student> insertStudent(@RequestBody @Valid StudentInsertDto std) {
        return studentService.registerStudent(std);
    }

    @GetMapping
    public ApiResponse<List<Student>> getUsers() {
        return studentService.getStudents();
    }

    @GetMapping("/{email}")
    public ApiResponse<Student> getStudent(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }
}
