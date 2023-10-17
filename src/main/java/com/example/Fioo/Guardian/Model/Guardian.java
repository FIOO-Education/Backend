package com.example.Fioo.Guardian.Model;

import com.example.Fioo.Guardian.Dto.PostGuardianDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codGuardian;
    @Column(name = "guardianname")
    private String guardianName;

    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String CPF;
    @Column(name = "kinship")
    private String kinship;
    @Column(name = "phone")
    private String phone;
    @Column(name = "passwordhash")
    private String passwordHash;
    public Guardian(PostGuardianDTO gdo) {
        this.guardianName = gdo.guardianName();
        this.email = gdo.email();
        this.CPF = gdo.cpf();
        this.phone = gdo.phone();
        this.kinship = gdo.kinship();
        this.passwordHash = gdo.passwordHash();
    }

    public Guardian(){}
}
