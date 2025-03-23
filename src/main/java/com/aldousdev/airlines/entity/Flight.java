package com.aldousdev.airlines.entity;
import com.aldousdev.airlines.enums.FlightStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @Column(unique = true)
    private String flightNumber;  // Например: "AA123"

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    private FlightStatus status;  // SCHEDULED, DELAYED, CANCELLED

    // Связи
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "flight")
    private List<CrewAssignment> crewAssignments;
}
