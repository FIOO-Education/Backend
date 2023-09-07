package com.example.Fioo.Guardian.Model;

import com.example.Fioo.Guardian.Dto.*;
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

    private String guardiaName;

    private String email;

    private String CPF;

    private String kinship;

    private Long codStudent;
    public Guardian(GuardianInsertDto guardian) {
        this.guardiaName = guardian.guardianName();
        this.email = guardian.email();
        this.CPF = guardian.cpf();;
        this.kinship = guardian.kinship();
        this.codStudent = guardian.codStudent();
    }

    public Guardian() {
    }
}
