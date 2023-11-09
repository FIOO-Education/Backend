package com.example.Fioo.Curriculum.Model;

import com.example.Fioo.Activities.Model.Activities;
import com.example.Fioo.Curriculum.Dto.CurriculumPostDto;
import com.example.Fioo.Student.Model.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

import com.example.Fioo.Activities.*;
import com.example.Fioo.Student.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Curriculum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codgrade")
    private Long codGrade;
    @Column(name = "codactivity")
    private Long codActivity;
    @Column(name = "codstudent")
    private Long codStudent;
    @Column(name = "grade")
    private double grade;
    @Column(name = "realizationdate")
    private Date realizationDate;

    @Column(name = "game")
    private boolean game;

    public Curriculum(CurriculumPostDto c) {
        this.codActivity = c.codActivity();
        this.codStudent = c.codStudent();
        this.game = c.game();
        this.realizationDate = c.realizationDate();
    }
}
