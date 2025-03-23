package com.aldousdev.airlines.repository;

import com.aldousdev.airlines.entity.Aircraft;
import com.aldousdev.airlines.enums.AircraftStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

    // Найти самолеты по модели (например, "Boeing 737-800")
    List<Aircraft> findByModel(String model);

    // Найти самолеты по статусу (например, ACTIVE)
    List<Aircraft> findByStatus(AircraftStatus status);

    // Найти самолеты с количеством мест больше заданного
    List<Aircraft> findByTotalSeatsGreaterThan(int seats);
}
