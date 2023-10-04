package com.example.Fioo.Guardian.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record PostGuardianDTO(
        @NotBlank
        String guardianName,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String phone,
        @NotBlank
        String passwordHash,
        @NotBlank
        String kinship
) {
}
