package com.example.Fioo.Guardian.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codGuardian;

    private String guardianName;

    private String email;

    private String CPF;

    private String kinship;

    private Long codStudent;
    public Guardian(String guardianName, String email, String CPF, String kinship, Long codStudent) {
        this.guardianName = guardianName;
        this.email = email;
        this.CPF = CPF;
        this.kinship = kinship;
        this.codStudent = codStudent;
    }

    public Guardian() {
    }
}
