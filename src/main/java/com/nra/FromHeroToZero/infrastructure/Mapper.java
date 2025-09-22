package com.nra.FromHeroToZero.infrastructure;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public CountryDTO toCountryDTO(Country country) {
        return new CountryDTO(
                country.getName()
        );
    }

    public Country toCountry(CountryDTO countryDTO) {
        return new Country(countryDTO.name());
    }

    public MeasurementDTO toMeasurementDTO(Measurement measurement) {
        return new MeasurementDTO(
                measurement.getValue(),
                measurement.getStatus(),
                measurement.getYear(),
                measurement.getCountry()
        );
    }

    public Measurement toMeasurement(MeasurementDTO measurementDTO) {
        return new Measurement(
                measurementDTO.value(),
                measurementDTO.status(),
                measurementDTO.year(),
                measurementDTO.country()
        );
    }
}
