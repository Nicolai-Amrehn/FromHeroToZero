package com.nra.FromHeroToZero.infrastructure;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.dto.MeasurementDTO;
import com.nra.FromHeroToZero.dto.MeasurementInputDTO;
import com.nra.FromHeroToZero.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final CountryRepository countryRepository;

    public Mapper(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryDTO toCountryDTO(Country country) {
        return new CountryDTO(
                country.getId(),
                country.getName()
        );
    }

    public Country toCountry(CountryDTO countryDTO) {
        return new Country(countryDTO.name());
    }

    public MeasurementInputDTO toMeasurementInputDTO(Measurement measurement) {
        return new MeasurementInputDTO(
                measurement.getValue(),
                measurement.getStatus(),
                measurement.getYear(),
                measurement.getCountry().getId()
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

    public Measurement toMeasurement(MeasurementInputDTO measurementInputDTO) {
        Country country = countryRepository.findById(measurementInputDTO.countryId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Invalid countryId: " + measurementInputDTO.countryId()
                ));

        return new Measurement(
                measurementInputDTO.value(),
                measurementInputDTO.status(),
                measurementInputDTO.year(),
                country
        );
    }
}
