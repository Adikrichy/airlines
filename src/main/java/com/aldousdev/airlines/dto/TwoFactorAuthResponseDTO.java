package com.aldousdev.airlines.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TwoFactorAuthResponseDTO {
    private String secret;
    private String qrCodeUrl;
}
