package com.example.Fioo.Questions.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codquestion")
    private Long codQuestion;
    @Column(name = "question")
    private String question;

    @Column(name = "codactivity")
    private Long codActivity;

    public Questions() {}
}
