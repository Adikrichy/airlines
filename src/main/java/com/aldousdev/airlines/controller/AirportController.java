package com.aldousdev.airlines.controller;

import com.aldousdev.airlines.dto.AirportDTO;
import com.aldousdev.airlines.service.AirportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/airports")
@Tag(name = "Airport Management")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AirportDTO> createAirport(@Valid @RequestBody AirportDTO airportDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.createAirport(airportDTO));
    }

    @GetMapping("/{iataCode}")
    public ResponseEntity<AirportDTO> getAirport(@PathVariable String iataCode) {
        return ResponseEntity.ok(airportService.getAirportByIataCode(iataCode));
    }

}
