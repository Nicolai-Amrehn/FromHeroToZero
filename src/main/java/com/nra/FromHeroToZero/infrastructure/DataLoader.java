package com.nra.FromHeroToZero.infrastructure;

import com.nra.FromHeroToZero.domain.Country;
import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.repository.CountryRepository;
import com.nra.FromHeroToZero.repository.MeasurementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final CountryRepository countryRepository;
    private final MeasurementRepository measurementRepository;

    public DataLoader(CountryRepository countryRepository, MeasurementRepository measurementRepository) {
        this.countryRepository = countryRepository;
        this.measurementRepository = measurementRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (countryRepository.count() == 0) {
            loadData();
        }
    }

    private void loadData() {
        Country china = countryRepository.save(new Country("China"));
        Country us = countryRepository.save(new Country("United States"));
        Country india = countryRepository.save(new Country("India"));
        Country russia = countryRepository.save(new Country("Russia"));
        Country japan = countryRepository.save(new Country("Japan"));
        Country germany = countryRepository.save(new Country("Germany"));
        Country iran = countryRepository.save(new Country("Iran"));
        Country skorea = countryRepository.save(new Country("South Korea"));
        Country saudi = countryRepository.save(new Country("Saudi Arabia"));
        Country indonesia = countryRepository.save(new Country("Indonesia"));
        Country canada = countryRepository.save(new Country("Canada"));
        Country brazil = countryRepository.save(new Country("Brazil"));
        Country uk = countryRepository.save(new Country("United Kingdom"));
        Country turkey = countryRepository.save(new Country("Turkey"));
        Country australia = countryRepository.save(new Country("Australia"));

        measurementRepository.saveAll(java.util.List.of(
                new Measurement(11472.0, Status.APPROVED, 2025, china),
                new Measurement(5007.3, Status.APPROVED, 2025, us),
                new Measurement(2654.8, Status.APPROVED, 2025, india),
                new Measurement(1711.3, Status.APPROVED, 2025, russia),
                new Measurement(1061.8, Status.APPROVED, 2025, japan),
                new Measurement(729.8, Status.APPROVED, 2025, germany),
                new Measurement(720.9, Status.APPROVED, 2025, iran),
                new Measurement(657.6, Status.APPROVED, 2025, skorea),
                new Measurement(635.8, Status.APPROVED, 2025, saudi),
                new Measurement(619.3, Status.APPROVED, 2025, indonesia),
                new Measurement(571.8, Status.APPROVED, 2025, canada),
                new Measurement(462.3, Status.APPROVED, 2025, brazil),
                new Measurement(348.3, Status.APPROVED, 2025, uk),
                new Measurement(372.4, Status.APPROVED, 2025, turkey),
                new Measurement(415.2, Status.APPROVED, 2025, australia),

                new Measurement(11893.2, Status.APPROVED, 2024, china),
                new Measurement(5273.5, Status.APPROVED, 2024, us),
                new Measurement(2441.9, Status.APPROVED, 2024, india),
                new Measurement(1756.8, Status.APPROVED, 2024, russia),

                new Measurement(720.5, Status.PROPOSED, 2025, germany),
                new Measurement(463.8, Status.PROPOSED, 2025, brazil),
                new Measurement(658.2, Status.REJECTED, 2025, skorea)
        ));

        System.out.println("Sample data loaded successfully!");
    }
}