package com.aldousdev.airlines.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class PasswordResetRequestDTO {
    @Email
    @NotBlank
    private String email;
}
