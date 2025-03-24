package com.aldousdev.airlines.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class PasswordResetDTO {
    @NotBlank
    private String token;
    @NotBlank
    private String newPassword;
}

