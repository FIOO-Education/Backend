package com.example.Fioo.Student;

import com.example.Fioo.Guardian.Dto.*;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Guard;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/insert")
    public void registerUser(StudentInsertDto student, GuardianInsertDto guardian) {
        studentService.registerUser(student, guardian);
    }
}
