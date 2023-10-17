package com.example.Fioo.Classes.Responses;

import com.example.Fioo.Classes.Model.Classes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GetClassesResponse {
    int statusCode;
    String messsage;
    List<Classes> data;
}
