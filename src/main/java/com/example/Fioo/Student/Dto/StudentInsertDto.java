package com.example.Fioo.Student.Dto;

import com.example.Fioo.Student.Enums.StudentLevel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record StudentInsertDto(
        @NotBlank
        String username,
        @NotBlank
        String educationLevel,
        @NotBlank
        StudentLevel cognitiveLevel,
        @NotBlank
        String image,
        @NotNull
        Long codGuardian
) {
}
