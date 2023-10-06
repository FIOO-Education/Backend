package com.example.Fioo.LoginLog.Dto;

import javax.validation.constraints.NotBlank;

public record LoginLogInsertDto(
        @NotBlank(message = "Cod Student should not be blank")
        Long codStudent,
        @NotBlank(message = "Act name should not be blank")
        String actName
) {
}
