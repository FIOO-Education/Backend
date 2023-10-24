package com.example.Fioo.Student.Model;

import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.Enums.StudentLevel;
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
    private Long codstudent;
    @Column(name = "username")
    private String username;
    @Column(name = "educationallevel")
    private String educationalLevel;
    @Column(name = "cognitivelevel")
    private String cognitiveLevel;
    @Column(name = "image")
    private String image;
    @Column(name = "codguardian")

    private Long codGuardian;

    public Student(StudentInsertDto sto) {
        this.username = sto.username();
        this.cognitiveLevel = sto.cognitiveLevel();
        this.codGuardian = sto.codGuardian();
    }
}
