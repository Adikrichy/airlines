package com.aldousdev.airlines.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "aircraft_types")
public class AircraftType {
    @Id
    private String model;  // Например: "B737"

    private int economySeats;
    private int businessSeats;
    private int firstClassSeats;
}