package com.example.Fioo.Curriculum.Dto;

import com.example.Fioo.Activities.Model.Activities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;

public record CurriculumPostDto(
        Long codActivity,
        Long codStudent,
        double grade,
        Date realizationDate
) {
}