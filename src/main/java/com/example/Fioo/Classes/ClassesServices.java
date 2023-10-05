package com.example.Fioo.Classes;

import com.example.Fioo.ApiResponse;
import com.example.Fioo.Classes.Model.Classes;
import com.example.Fioo.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServices {
    private ClassesRepository repo;
    @Autowired
    public ClassesServices(ClassesRepository classesRepository) {
        this.repo = classesRepository;
    }
    public ApiResponse<List<Classes>> getClasses() {
        try {
            return new ApiResponse<>(HttpStatus.OK.value(), MessageRequest.SUCCESS.getMessage(), repo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageRequest.INTERNAL_SERVER_ERROR.getMessage(),null);
        }
    }
}
