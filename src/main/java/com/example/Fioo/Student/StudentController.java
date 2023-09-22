package com.example.Fioo.Student;

import com.example.Fioo.Guardian.GuardianService;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Guard;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(
            StudentService studentService
    ) {
        this.studentService = studentService;
    }
    @PostMapping("")
    public ResponseEntity<Student> insertStudent(@RequestBody StudentInsertDto std) {
        try {
            Student payload = studentService.registerStudent(std);
            return ResponseEntity.ok(payload);
        } catch (Exception err) {
            return ResponseEntity.badRequest().body(new Student(std));
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getUsers() {
        try {
            return ResponseEntity.ok(studentService.getStudents());
        } catch (Exception err) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable String email) {
        try {
            Optional<Student> payload = studentService.getStudentByEmail(email);
            return ResponseEntity.ok(payload);
        } catch (Exception err) {
            err.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
