package com.example.Fioo.Classes;

import com.example.Fioo.Classes.Model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServices {
    private ClassesRepository repo;
    @Autowired
    public ClassesServices(ClassesRepository classesRepository) {
        this.repo = classesRepository;
    }
    public List<Classes> getClasses() {
        return repo.findAll();
    }
}
