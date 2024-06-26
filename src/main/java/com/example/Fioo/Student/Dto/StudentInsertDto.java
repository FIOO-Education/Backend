package com.example.Fioo.Student.Dto;

import com.example.Fioo.Student.Enums.StudentLevel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record StudentInsertDto(
        @NotBlank(message = "Username should not blank")
        String username,
        @NotBlank(message = "Cognitive Level should not blank")
        String cognitiveLevel,
        @NotNull(message = "CPF should not blank")
        Long codGuardian
) {
}
