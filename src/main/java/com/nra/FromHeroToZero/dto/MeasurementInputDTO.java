package com.nra.FromHeroToZero.dto;

import com.nra.FromHeroToZero.infrastructure.Status;

public record MeasurementInputDTO(
    Double value,
    Status status,
    int year,
    Long countryId
    ) {}
