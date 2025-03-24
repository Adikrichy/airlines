package com.aldousdev.airlines.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int statusCode;
    private Instant timestamp;
}
