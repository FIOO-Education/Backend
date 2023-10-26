package com.example.Fioo.Questions.Dto;

import jakarta.persistence.Column;

public record QuestionsDTO(String question,
                           Long codActivity) {
}
