package com.aldousdev.airlines.repository;

import com.aldousdev.airlines.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    // Найти по коду IATA (например, "JFK")
    Optional<Airport> findByIataCode(String iataCode);

    // Найти по коду ICAO (например, "KJFK")
    Optional<Airport> findByIcaoCode(String icaoCode);

    // Поиск по городу (например, "New York")
    List<Airport> findByLocationCity(String city);

    // Кастомный запрос: аэропорты с терминалом "A"
    @Query("SELECT a FROM Airport a WHERE :terminal MEMBER OF a.terminals")
    List<Airport> findAirportsByTerminal(String terminal);

    boolean existsByIataCode(String iataCode);

}
