package com.aldousdev.airlines.repository;

import com.aldousdev.airlines.entity.FlightAnalytics;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

public class CustomAnalyticsRepositoryImpl implements CustomAnalyticsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FlightAnalytics> getFlightAnalytics(LocalDate startDate, LocalDate endDate) {
        String jpql = """
            SELECT NEW com.airlines.modules.analytics.model.FlightAnalytics(
                f.flightNumber, 
                COUNT(t), 
                AVG(t.price), 
                SUM(f.fuelConsumption)
            )
            FROM Flight f
            JOIN f.tickets t
            WHERE f.departureTime BETWEEN :start AND :end
            GROUP BY f.flightNumber
            """;

        return entityManager.createQuery(jpql, FlightAnalytics.class)
                .setParameter("start", startDate.atStartOfDay())
                .setParameter("end", endDate.atTime(23, 59, 59))
                .getResultList();
    }
}
