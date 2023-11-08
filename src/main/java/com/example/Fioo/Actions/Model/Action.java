package com.example.Fioo.Actions.Model;

import com.example.Fioo.Actions.Dto.PostActionDto;
import com.example.Fioo.Activities.Model.Activities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "actiondate")
    private Date actionDate;
    @Column(name = "codstudent")
    private Long codStudent;

    @JsonProperty(namespace = "Activity")
    @OneToOne
    @JoinColumn()
    private Activities activities;
    @Column(name = "codclass")
    private Long codClass;
    @Column(name = "codactivity")
    private Long codActivity;

    public Action(PostActionDto p) {
        this.actionDate = p.actionDate();
        this.codStudent = p.codStudent();
        this.codClass = p.codClass();
        this.activities = p.activity();
    }
}
