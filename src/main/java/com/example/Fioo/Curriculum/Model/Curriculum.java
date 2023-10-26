package com.example.Fioo.Curriculum.Model;

import com.example.Fioo.Activities.Model.Activities;
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

    @JsonProperty("activity")
    @OneToOne()
    @JoinColumn(name = "codactivity", referencedColumnName = "codactivity")
    private Activities activity;
    @Column(name = "codstudent")
    private Long codStudent;
    @Column(name = "grade")
    private double grade;
    @Column(name = "realizationdate")
    private Date realizationDate;
}
