package com.example.Fioo.Questions.Model;

import com.example.Fioo.Alternatives.Model.Alternatives;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

    @Column(name = "image")
    private String image;

    @Column(name = "codactivity")
    private Long codActivity;

    @OneToMany
    @JsonProperty("alternatives")
    @JoinColumn(name = "codquestion", referencedColumnName = "codquestion")
    private List<Alternatives> alternatives;
    public Questions() {}
}