package com.nra.FromHeroToZero.dto;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.infrastructure.Status;

public record MeasurementDTO(
    Double value,
    Status status,
    int year,
    Country country
) {}
