package com.example.Fioo.Alternatives.Model;

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
public class Alternatives {
    @Id
    @Column(name = "codalternative")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codAlternative;

    @Column(name = "alternative")
    private String alternavite;

    @Column(name = "correct")
    private boolean correct;

    @Column(name = "codQuestion")
    private Long codQuestion;
}
