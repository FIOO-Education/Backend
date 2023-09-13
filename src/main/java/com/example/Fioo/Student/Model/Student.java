package com.example.Fioo.Student.Model;

import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.StudentController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private Long codEducationLevel;

    private Long codStudentLevel;

    private Long imageStudent;

    public Student(String username, Long codEducationLevel, Long codStudentLevel, Long imageStudent) {
        this.username = username;
        this.codEducationLevel = codEducationLevel;
        this.codStudentLevel = codEducationLevel;
        this.imageStudent = imageStudent;
    }
}
