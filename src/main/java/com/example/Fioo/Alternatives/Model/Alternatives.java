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
    @Column(name = "codAlternative")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAlternative;

    @Column(name = "alternative")
    private String alternative;

    @Column(name = "correct")
    private Boolean correct;

    @Column(name = "codQuestion")
    private Long codQuestion;
}
