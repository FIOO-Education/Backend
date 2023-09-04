package com.example.Fioo.Guardian.Model;

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
    private Long guardiaName;

    @Column
    private String email;

    @Column
    private String CPF;

    @Column
    private String kinship;

    @Column
    private Long codStudentFK;
}
