package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.LoyaltyProgram;
import com.aldousdev.airlines.enums.LoyaltyTier;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgram, Long> {

    // Найти программы по уровню лояльности
    List<LoyaltyProgram> findByTier(LoyaltyTier tier);

    // Найти программу по ID клиента
    LoyaltyProgram findByCustomerId(Long customerId);
}
