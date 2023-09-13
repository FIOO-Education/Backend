package com.example.Fioo.Student.Dto;

public record StudentInsertDto(
        String username,
        Long codEducationLevel,
        Long codStudentLevel,
        Long imageStudent,
        String guardianName,
        String email,
        String cpf,
        String kinship,
        Long codStudent
) {
}
