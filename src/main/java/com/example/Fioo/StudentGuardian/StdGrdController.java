package com.example.Fioo.StudentGuardian;

import com.example.Fioo.Guardian.Dto.GuardianInsertDto;
import com.example.Fioo.Guardian.GuardianService;
import com.example.Fioo.Guardian.Model.Guardian;
import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Model.Student;
import com.example.Fioo.Student.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Guard;

@RestController
@RequestMapping("/api")
public class StdGrdController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private GuardianService guardianService;

    @PostMapping("/registerUser")
    public ResponseEntity<String> insertUser(@RequestBody StudentInsertDto std, GuardianInsertDto grd) {
        guardianService.insertGuardian(new Guardian(grd));
        studentService.registerUser(new Student(std));
        return ResponseEntity.ok("Usuário inserido com sucesso!");
    }
}
