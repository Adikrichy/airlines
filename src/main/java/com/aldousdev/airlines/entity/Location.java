package com.aldousdev.airlines.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Location {
    private String city;
    private String country;
    private Double latitude;
    private Double longitude;
}