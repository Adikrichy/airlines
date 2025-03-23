package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.Ticket;
import com.aldousdev.airlines.enums.TravelClass;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {

    // Найти билеты по номеру бронирования
    List<Ticket> findByBookingBookingId(UUID bookingId);

    // Найти билеты по рейсу
    List<Ticket> findByFlightFlightNumber(String flightNumber);

    // Найти билеты по классу обслуживания
    List<Ticket> findByTravelClass(TravelClass travelClass);
}
