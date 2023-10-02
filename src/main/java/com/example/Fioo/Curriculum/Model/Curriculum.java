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
    @Column(name = "realizationdata")
    private Date realizationData;

    public Curriculum(Optional<Curriculum> c) {
        this.codGrade = c.get().getCodGrade();
        this.codActivity = c.get().getCodActivity();
        this.codStudent = c.get().getCodStudent();
        this.grade = c.get().getGrade();
        this.realizationData = c.get().getRealizationData();
    }

}
