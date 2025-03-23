package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.CrewAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CrewAssignmentRepository extends JpaRepository<CrewAssignment, Long> {

    // Найти назначения по рейсу
    List<CrewAssignment> findByFlightFlightNumber(String flightNumber);

    // Найти назначения по сотруднику
    List<CrewAssignment> findByEmployeeId(Long employeeId);
}
