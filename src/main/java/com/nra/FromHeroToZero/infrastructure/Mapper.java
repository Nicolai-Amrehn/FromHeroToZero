package com.nra.FromHeroToZero.infrastructure;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.dto.CountryDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public CountryDTO toCountryDTO(Country country) {
        String countryName = country.getName();
        return new CountryDTO(countryName);
    }

    public Country toCountry(CountryDTO countryDTO) {
        return new Country(countryDTO.name());
    }
}
