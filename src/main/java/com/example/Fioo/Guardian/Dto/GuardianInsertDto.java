package com.example.Fioo.Guardian.Dto;

public record GuardianInsertDto(
        String guardianName,
        String email,
        String cpf,
        String kinship,
        Long codStudent
) {
}
