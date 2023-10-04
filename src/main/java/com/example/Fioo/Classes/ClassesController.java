package com.example.Fioo.Classes;

import com.example.Fioo.Classes.Model.Classes;
import com.example.Fioo.Classes.Responses.GetClassesResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public GetClassesResponse getClasses() {
        return repo.getClasses();
    }
}
