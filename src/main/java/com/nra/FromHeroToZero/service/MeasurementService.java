package com.nra.FromHeroToZero.service;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.infrastructure.Mapper;
import com.nra.FromHeroToZero.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final Mapper mapper;

    public MeasurementService(MeasurementRepository measurementRepository, Mapper mapper) {
        this.measurementRepository = measurementRepository;
        this.mapper = mapper;
    }

    public List<Measurement> getAllMeasurementsByCountryId(Long countryId) {
        return measurementRepository.findByCountryId(countryId);
    }

    public List<Measurement> getAllMeasurementsByCountry(Country country) {
        return measurementRepository.findByCountry(country);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public void createMeasurement(MeasurementDTO measurementDTO) {
        Measurement measurement = mapper.toMeasurement(measurementDTO);
        measurementRepository.save(measurement);
    }
}
