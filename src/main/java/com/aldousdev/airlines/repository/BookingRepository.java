package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.Booking;
import com.aldousdev.airlines.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {  // ID = UUID

    // Найти бронирования по статусу (например, CONFIRMED)
    List<Booking> findByStatus(BookingStatus status);

    // Найти бронирования клиента (по ID клиента)
    List<Booking> findByCustomerId(Long customerId);
}