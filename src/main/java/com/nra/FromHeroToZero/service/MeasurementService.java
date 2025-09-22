package com.nra.FromHeroToZero.service;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.dto.MeasurementInputDTO;
import com.nra.FromHeroToZero.infrastructure.Mapper;
import com.nra.FromHeroToZero.infrastructure.Status;
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

    public List<MeasurementDTO> getAllMeasurements() {
        return measurementRepository.findAll()
                .stream()
                .map(mapper::toMeasurementDTO)
                .collect(toList());
    }

    public void createMeasurement(MeasurementInputDTO measurementInputDTO) {
        Measurement measurement = mapper.toMeasurement(measurementInputDTO);
        measurement.setStatus(Status.PROPOSED);
        measurementRepository.save(measurement);
    }

    public List<MeasurementDTO> getMeasurementsInOrder() {
        return measurementRepository.findByYearAndStatusOrderByValueDesc(LocalDate.now().getYear(), Status.APPROVED)
                .stream()
                .map(mapper::toMeasurementDTO)
                .collect(toList());
    }

    public MeasurementDTO getMeasurementById(Long id) {
        return mapper.toMeasurementDTO(measurementRepository.getReferenceById(id));
    }

    public void updateMeasurement(Long id, Status status) {
        Measurement measurement = measurementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid measurement ID: " + id));

        measurement.setStatus(status);

        measurementRepository.save(measurement);
    }

}
