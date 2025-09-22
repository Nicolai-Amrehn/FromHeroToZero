package com.nra.FromHeroToZero.service;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
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

    public void createMeasurement(Measurement measurement) {
        measurementRepository.save(measurement);
    }

}
