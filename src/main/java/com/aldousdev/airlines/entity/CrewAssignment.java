package com.aldousdev.airlines.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "crew_assignments")
public class CrewAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    private String roleInFlight;  // "Captain", "First Officer"
}
