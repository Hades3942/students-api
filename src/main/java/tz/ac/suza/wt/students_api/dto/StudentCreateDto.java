package tz.ac.suza.wt.students_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentCreateDto(

        @NotBlank(message = "name is required")
        @Size(min = 2, max = 100, message = "name must be 2..100 characters")
        String name,

        @NotBlank(message = "email is required")
        @Email(message = "email must be a valid address")
        @Size(max = 150)
        String email,

        @NotBlank(message = "course is required")
        @Size(min = 2, max = 100)
        String course,

        @NotNull(message = "year is required")
        @Min(value = 1, message = "year must be between 1 and 4")
        @Max(value = 4, message = "year must be between 1 and 4")
        Integer year
) {}
