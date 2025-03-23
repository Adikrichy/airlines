package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.Aircraft;
import com.aldousdev.airlines.entity.Flight;
import com.aldousdev.airlines.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    // Найти места в конкретном самолете
    List<Seat> findByAircraftId(Long aircraftId);

    // Кастомный запрос: свободные места на рейс
    @Query("SELECT s FROM Seat s WHERE s.aircraft = :aircraft AND s NOT IN " +
            "(SELECT t.seat FROM Ticket t WHERE t.flight = :flight)")
    List<Seat> findAvailableSeatsForFlight(
            @Param("aircraft") Aircraft aircraft,
            @Param("flight") Flight flight
    );
}
