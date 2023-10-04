package com.example.Fioo.Curriculum.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Optional;

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
}
