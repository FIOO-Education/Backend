package com.example.Fioo.Guardian.Dto;

import com.example.Fioo.Guardian.Model.Guardian;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record GetGuardianDTO (
    Long id,
    String guardianName,
    String email,
    String cpf,
    String phone,
    String kinship
){
    public GetGuardianDTO(Guardian g) {
        this(g.getCodGuardian(), g.getGuardianName(), g.getEmail(), g.getCPF(), g.getPhone(), g.getKinship());
    }
}
