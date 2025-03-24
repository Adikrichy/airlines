package com.aldousdev.airlines.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class UserProfileDTO {
    @Email
    @NotBlank
    private String email;
    private String firstName;
    private String lastName;
    // Можно добавить дополнительные поля профиля
}

