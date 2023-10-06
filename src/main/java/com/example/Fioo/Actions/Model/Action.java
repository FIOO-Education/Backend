package com.example.Fioo.Actions.Model;

import com.example.Fioo.Actions.Dto.PostActionDto;
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
    @Column(name = "codclass")
    private Long codClass;
    @Column(name = "codactivity")
    private Long codActivity;

    public Action(PostActionDto p) {
        this.actionDate = p.actionDate();
        this.codStudent = p.codStudent();
        this.codClass = p.codClass();
        this.codActivity = p.codActivity();
    }
}
