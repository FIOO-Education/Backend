package com.example.Fioo.Classes;

import com.example.Fioo.Classes.Model.Classes;
import com.example.Fioo.Classes.Responses.GetClassesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesServices {
    private ClassesRepository repo;
    @Autowired
    public ClassesServices(ClassesRepository classesRepository) {
        this.repo = classesRepository;
    }
    public GetClassesResponse getClasses() {
        try {
            return new GetClassesResponse(200, "Success", repo.findAll());
        } catch (HttpServerErrorException.InternalServerError e) {
            System.out.println("macao");
            e.printStackTrace();
            return new GetClassesResponse(500, "Internal Server Error",  null);
        }
    }
}
