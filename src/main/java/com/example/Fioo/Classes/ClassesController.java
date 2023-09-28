package com.example.Fioo.Classes;

import com.example.Fioo.Classes.Model.Classes;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassesController {
    private ClassesServices repo;
    @Autowired
    public ClassesController(ClassesServices classesServices) {
        this.repo = classesServices;
    }
    @GetMapping("")
    public ResponseEntity<List<Classes>> getClasses() {
        try {
            return ResponseEntity.ok(repo.getClasses());
        } catch (Exception err) {
            return ResponseEntity.badRequest().build();
        }
    }
}
