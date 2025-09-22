package com.nra.FromHeroToZero.dto;

import com.nra.FromHeroToZero.infrastructure.Status;

public record MeasurementDTO(
        Long id,
        Double value,
        Status status,
        int year,
        CountryDTO country
        ) {}
