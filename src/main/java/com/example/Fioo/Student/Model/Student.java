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

    public Student(StudentInsertDto data) {
        this.username = data.username();
        this.codEducationLevel = data.codEducationLevel();
        this.codStudentLevel = data.codEducationLevel();
        this.imageStudent = data.imageStudent();
    }
}
