package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.Flight;
import com.aldousdev.airlines.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {  // ID = flightNumber (String)

    // Найти рейсы по статусу (например, DELAYED)
    List<Flight> findByStatus(FlightStatus status);

    // Найти рейсы между датами
    List<Flight> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);

    // Найти рейсы из аэропорта (по ID аэропорта)
    List<Flight> findByDepartureAirportId(Long airportId);
}
