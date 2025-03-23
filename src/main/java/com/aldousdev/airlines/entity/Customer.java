package com.aldousdev.airlines.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String passportNumber;

    // Связи
    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    @OneToOne(mappedBy = "customer")
    private LoyaltyProgram loyaltyProgram;
}
