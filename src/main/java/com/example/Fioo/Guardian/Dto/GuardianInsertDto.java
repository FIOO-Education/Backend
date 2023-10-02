package com.example.Fioo.Guardian.Dto;

public record GuardianInsertDto(
        String guardianName,
        String email,
        String cpf,
        String phone,
        String passwordHash,
        String kinship
) {
}
