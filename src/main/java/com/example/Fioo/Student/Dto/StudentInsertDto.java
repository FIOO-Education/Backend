package com.example.Fioo.Student.Dto;

public record StudentInsertDto(
        String username,
        String educationLevel,
        String cognitiveLevel,
        String image,
        Long codGuardian

) {
}
