package com.example.Fioo.Activities.Model;

import com.example.Fioo.Activities.Dto.ActivitiesRequestDto;
import com.example.Fioo.Questions.Model.Questions;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codactivity")
    private Long codActivity;

    @Column(name = "title")
    private String title;
    @Column(name = "subject")
    private String subject;

    @Column(name = "codclass")
    private Long codClass;

    @JsonProperty("questions")
    @OneToMany
    @JoinColumn(name = "codactivity", referencedColumnName = "codactivity")
    private List<Questions> questions;

    public Activities(ActivitiesRequestDto a) {
        this.title = a.title();
        this.image = a.image();
        this.subject = a.subject();
        this.codClass = a.codClass();
    }
}
