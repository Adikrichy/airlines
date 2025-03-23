package com.aldousdev.airlines.repository;

import com.aldousdev.airlines.entity.FlightAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnalyticsRepository extends JpaRepository<FlightAnalytics, Long>, CustomAnalyticsRepository {
}
