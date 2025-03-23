package com.aldousdev.airlines.entity;
import com.aldousdev.airlines.enums.AircraftStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "aircrafts")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String model;  // Например: "Boeing 737-800"

    @Column(unique = true)
    private String serialNumber;

    @Column(nullable = false)
    private int totalSeats;

    @Enumerated(EnumType.STRING)
    private AircraftStatus status;  // ACTIVE, UNDER_MAINTENANCE

    @ManyToOne
    @JoinColumn(name = "aircraft_type_id")
    private AircraftType type;

    // Связь с рейсами
    @OneToMany(mappedBy = "aircraft")
    private List<Flight> flights;
}
