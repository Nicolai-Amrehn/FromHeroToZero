package com.nra.FromHeroToZero.repository;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByCountry(Country country);

    List<Measurement> findByCountryId(Long countryId);

    List<Measurement> findTop10ByYearOrderByValueDesc(int year);
}
