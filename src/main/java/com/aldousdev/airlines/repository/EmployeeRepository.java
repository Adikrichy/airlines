package com.aldousdev.airlines.repository;
import com.aldousdev.airlines.entity.Employee;
import com.aldousdev.airlines.enums.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Найти сотрудников по роли (например, PILOT)
    List<Employee> findByRole(EmployeeRole role);

    // Найти сотрудников с определенной лицензией (например, "ATP-123")
    @Query("SELECT e FROM Employee e WHERE :license MEMBER OF e.licenses")
    List<Employee> findByLicense(String license);
}
