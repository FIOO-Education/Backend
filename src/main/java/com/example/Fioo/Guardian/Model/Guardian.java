package com.example.Fioo.Guardian.Model;

import com.example.Fioo.Guardian.Dto.*;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "guardian")
public class Guardian {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codGuardian;

    @Column
    private String guardiaName;

    @Column
    private String email;

    @Column
    private String CPF;

    @Column
    private String kinship;

    @Column
    private Long codStudent;

    public Guardian(GuardianInsertDto guardian) {
        this.guardiaName = guardian.guardianName();
        this.email = guardian.email();
        this.CPF = guardian.cpf();;
        this.kinship = guardian.kinship();
        this.codStudent = guardian.codStudent();
    }
}
