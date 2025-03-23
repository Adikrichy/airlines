package com.aldousdev.airlines.entity;
import com.aldousdev.airlines.enums.TravelClass;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String seatNumber;  // Например: "12A"

    @Enumerated(EnumType.STRING)
    private TravelClass travelClass;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;
}
