package com.example.Fioo.Curriculum.Responses;

import com.example.Fioo.Curriculum.Model.Curriculum;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetAllResponse {
    int statusCode;
    String message;
    List<Curriculum> data;
}
