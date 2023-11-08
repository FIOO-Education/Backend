package com.example.Fioo.Questions.Dto;

import jakarta.persistence.Column;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record QuestionsDTO(
        @NotBlank(message = "Question should not be blank")
        String question,
        @NotBlank(message = "Question Image should not be blank")
        String image,
        @NotNull(message = "CodActivity should not be null")
        Long codActivity
) {
}
