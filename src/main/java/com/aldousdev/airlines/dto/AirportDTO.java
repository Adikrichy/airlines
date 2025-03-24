package com.aldousdev.airlines.dto;

import lombok.Data;

@Data
public class AirportDTO {
    private Long id;
    private String name;
    private String iataCode;
    // Можно добавить дополнительные поля при необходимости
}

