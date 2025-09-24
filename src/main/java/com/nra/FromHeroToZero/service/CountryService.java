package com.nra.FromHeroToZero.service;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.dto.CountryDTO;
import com.nra.FromHeroToZero.infrastructure.Mapper;
import com.nra.FromHeroToZero.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final Mapper mapper;

    public CountryService(CountryRepository countryRepository, Mapper mapper) {
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAllByOrderByNameAsc()
                .stream()
                .map(mapper::toCountryDTO)
                .collect(toList());
    }

    public void createCountry(CountryDTO countryDTO) {
        Country country = mapper.toCountry(countryDTO);
        countryRepository.save(country);
    }
}
