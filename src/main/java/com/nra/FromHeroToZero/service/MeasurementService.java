package com.nra.FromHeroToZero.service;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.dto.MeasurementInputDTO;
import com.nra.FromHeroToZero.infrastructure.Mapper;
import com.nra.FromHeroToZero.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public List<MeasurementDTO> getAllMeasurements() {
        return measurementRepository.findAll()
                .stream()
                .map(mapper::toMeasurementDTO)
                .collect(toList());
    }

    public void createMeasurement(MeasurementInputDTO measurementInputDTO) {
        Measurement measurement = mapper.toMeasurement(measurementInputDTO);
        measurementRepository.save(measurement);
    }

    public List<MeasurementDTO> getTopTenMeasurements() {
        return measurementRepository.findTop10ByYearOrderByValueDesc(LocalDate.now().getYear())
                .stream()
                .map(mapper::toMeasurementDTO)
                .collect(toList());
    }

}
