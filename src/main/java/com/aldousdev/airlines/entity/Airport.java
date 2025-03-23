package com.aldousdev.airlines.entity;

import jakarta.persistence.*;
import lombok.Data;
import javax.xml.stream.Location;
import java.util.List;

@Data
@Entity
@Table(name = "airports",
        indexes = @Index(columnList = "iataCode, icaoCode"))
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 3)
    private String iataCode;  // Например: "JFK"

    @Column(unique = true, length = 4)
    private String icaoCode;  // Например: "KJFK"

    @Column(nullable = false)
    private String name;

    @Embedded
    private Location location;  // Город, страна, координаты

    @ElementCollection
    @CollectionTable(name = "airport_terminals")
    private List<String> terminals;  // Список терминалов: ["T1", "T2"]

    // Связи
    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departingFlights;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivingFlights;
}
