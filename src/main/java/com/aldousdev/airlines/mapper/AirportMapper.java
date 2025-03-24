package com.aldousdev.airlines.mapper;

import com.aldousdev.airlines.dto.AirportDTO;
import com.aldousdev.airlines.entity.Airport;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper {

    public Airport toEntity(AirportDTO dto) {
        if (dto == null) {
            return null;
        }
        Airport airport = new Airport();
        airport.setId(dto.getId());
        airport.setName(dto.getName());
        airport.setIataCode(dto.getIataCode());
        return airport;
    }

    public AirportDTO toDTO(Airport airport) {
        if (airport == null) {
            return null;
        }
        AirportDTO dto = new AirportDTO();
        dto.setId(airport.getId());
        dto.setName(airport.getName());
        dto.setIataCode(airport.getIataCode());
        return dto;
    }
}
