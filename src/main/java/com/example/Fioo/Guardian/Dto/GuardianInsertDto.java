package com.example.Fioo.Guardian.Dto;

import jakarta.persistence.Column;

public record GuardianInsertDto(
        String guardianName,
        String email,
        String cpf,
        String kinship,
        Long codStudent
) {
}
