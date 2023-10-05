package com.example.Fioo.Guardian.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record PostGuardianDTO(
        @NotBlank(message = "name should not blank")
        String guardianName,
        @NotBlank(message = "Email should not blank")
        @Email
        String email,
        @NotBlank(message = "CPF should not blank")
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank(message = "Phone should not blank")
        String phone,
        @NotBlank(message = "Password hash should not blank")
        String passwordHash,
        @NotBlank (message = "Kinship should not blank")
        String kinship
) {
}
