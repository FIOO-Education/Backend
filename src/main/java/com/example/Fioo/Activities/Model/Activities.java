package com.example.Fioo.Activities.Model;

import com.example.Fioo.Activities.Dto.ActivitiesRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "image")
    private String image;

    @Column(name = "subject")
    private String subject;

    @Column(name = "codclass")
    private long codClass;

    public Activities(ActivitiesRequestDto a) {
        this.title = a.title();
        this.image = a.image();
        this.subject = a.subject();
        this.codClass = a.codClass();
    }
}
