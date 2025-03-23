package com.aldousdev.airlines.entity;
import com.aldousdev.airlines.enums.LoyaltyTier;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "loyalty_programs")
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private int miles;
    private LoyaltyTier tier;  // SILVER, GOLD, PLATINUM
}
