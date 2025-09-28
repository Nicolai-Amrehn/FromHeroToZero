package com.nra.FromHeroToZero.infrastructure;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.dto.MeasurementInputDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Mapper() {
    }

    public CountryDTO toCountryDTO(Country country) {
        return new CountryDTO(
                country.getId(),
                country.getName()
        );
    }

    public MeasurementDTO toMeasurementDTO(Measurement measurement) {
        return new MeasurementDTO(
                measurement.getId(),
                measurement.getValue(),
                measurement.getStatus(),
                measurement.getYear(),
                measurement.getCountry() != null ? toCountryDTO(measurement.getCountry()) : null
        );
    }

    public Measurement toMeasurement(MeasurementInputDTO measurementInputDTO, Country country) {
        return new Measurement(
                measurementInputDTO.value(),
                measurementInputDTO.status(),
                measurementInputDTO.year(),
                country
        );
    }
}
