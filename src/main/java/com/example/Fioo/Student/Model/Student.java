package com.example.Fioo.Student.Model;

import com.example.Fioo.Student.Dto.StudentInsertDto;
import com.example.Fioo.Student.StudentController;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;

    @Column
    private Long codEducationLevel;

    @Column
    private Long codStudentLevel;
    @Column
    private Long imageStudent;

    public Student(StudentInsertDto data) {
        this.username = data.username();
        this.codEducationLevel = data.codEducationLevel();
        this.codStudentLevel = data.codEducationLevel();
        this.imageStudent = data.imageStudent();
    }
}
