package com.aldousdev.airlines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
public class FlightAnalytics {
    @Id
    private String flightNumber;
    private Long ticketsSold;
    private BigDecimal averagePrice;
    private Double totalFuelConsumption;

    // Конструкторы, геттеры, сеттеры
}
