package com.example.Fioo.Student;

import com.example.Fioo.Guardian.GuardianService;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Guard;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    private GuardianService guardianService;

    @Autowired
    public StudentController(
            StudentService studentService,
            GuardianService guardianService
    ) {
        this.studentService = studentService; this.guardianService = guardianService;
    }
    @PostMapping("")
    public ResponseEntity<String> insertUser(@RequestBody StudentInsertDto std) {
        try {
            guardianService.insertGuardian(new Guardian(std.guardianName(), std.email(), std.cpf(), std.kinship(), std.codStudent()));
            studentService.registerUser(new Student(std.username(), std.codEducationLevel(), std.codStudentLevel(), std.studentImage()));
        } catch (Exception err) {
            err.printStackTrace();
        }
        return ResponseEntity.ok("Usuário inserido com sucesso!");
    }

    @GetMapping("")
    public List<Student> getUsers() {
        try {
            List<Student> students = studentService.getUsers();
                    return students;
        } catch (Exception err) {
            throw err;
        }
    }

    @GetMapping("/:email")
    public Student getUser(@RequestParam String email) {
        try {
            Student payload = studentService.getUserByEmail("caio");
            return payload;
        } catch (Exception err) {
            throw err;
        }
    }
}
