package com.aldousdev.airlines.entity;
import com.aldousdev.airlines.enums.EmployeeRole;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;  // PILOT, FLIGHT_ATTENDANT

    @ElementCollection
    @CollectionTable(name = "employee_licenses")
    private Set<String> licenses;  // Номера лицензий

    // Связи
    @OneToMany(mappedBy = "employee")
    private List<CrewAssignment> assignments;
}
