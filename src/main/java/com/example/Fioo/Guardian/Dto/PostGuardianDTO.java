package com.example.Fioo.Guardian.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record PostGuardianDTO(
        @NotBlank(message = "name should not blank")
        String guardianName,
        @NotBlank(message = "Email should not blank")
        @Email(message = "Email must have follow the pattern of an email")
        String email,
        @NotBlank(message = "CPF should not blank")
        @Pattern(regexp = "\\d{11}", message = "CPF must have 11 digits")
        String cpf,
        @NotBlank(message = "Phone should not blank")
        String phone,
        @NotBlank(message = "Password hash should not blank")
        String passwordHash,
        @NotBlank (message = "Kinship should not blank")
        String kinship
) {
}
