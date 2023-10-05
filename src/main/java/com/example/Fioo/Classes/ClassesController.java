package com.example.Fioo.Classes;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Classes.Model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassesController {
    private ClassesServices repo;
    @Autowired
    public ClassesController(ClassesServices classesServices) {
        this.repo = classesServices;
    }
    @GetMapping
    public ApiResponse<List<Classes>> getClasses() {
        return repo.getClasses();
    }
}
