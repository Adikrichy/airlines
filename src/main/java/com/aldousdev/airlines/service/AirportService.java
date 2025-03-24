package com.aldousdev.airlines.service;

import com.aldousdev.airlines.dto.AirportDTO;
import com.aldousdev.airlines.entity.Airport;
import com.aldousdev.airlines.exceptions.ResourceConflictException;
import com.aldousdev.airlines.exceptions.ResourceNotFoundException;
import com.aldousdev.airlines.mapper.AirportMapper;
import com.aldousdev.airlines.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public AirportDTO createAirport(AirportDTO airportDTO) {
        if (airportRepository.existsByIataCode(airportDTO.getIataCode())) {
            throw new ResourceConflictException("Airport with IATA code already exists");
        }
        Airport airport = airportMapper.toEntity(airportDTO);
        return airportMapper.toDTO(airportRepository.save(airport));
    }

    public AirportDTO getAirportByIataCode(String iataCode) {
        Airport airport = airportRepository.findByIataCode(iataCode)
                .orElseThrow(() -> new ResourceNotFoundException("Airport not found"));
        return airportMapper.toDTO(airport);
    }
}
