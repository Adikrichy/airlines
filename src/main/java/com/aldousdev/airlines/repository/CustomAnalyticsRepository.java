// 5.1. Интерфейс
package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.FlightAnalytics;

import java.time.LocalDate;
import java.util.List;

public interface CustomAnalyticsRepository {
    List<FlightAnalytics> getFlightAnalytics(LocalDate startDate, LocalDate endDate);
}
