package com.aldousdev.airlines.entity;
import com.aldousdev.airlines.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookingId;  // Пример: "6d62d909-f957-430e-8689-b5129c1b9b34"

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    private BigDecimal totalPrice;
    private BookingStatus status;  // CONFIRMED, CANCELLED
}
