package com.example.Fioo.Actions.Dto;

import com.example.Fioo.Activities.Model.Activities;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public record PostActionDto(
        @NotBlank(message = "Action date should not be blank")
        Date actionDate,
        @NotBlank(message = "Cod of the student should not be blank")
        Long codStudent,
        @NotBlank(message = "Cod of the class should not be blank")
        Long codClass,
        @NotBlank(message = "Cod of the Activity should not be blank")
        Long codActivity
) {
}
