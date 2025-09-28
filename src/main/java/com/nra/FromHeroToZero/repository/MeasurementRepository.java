package com.nra.FromHeroToZero.repository;

import com.nra.FromHeroToZero.domain.Measurement;
import com.nra.FromHeroToZero.infrastructure.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByYearAndStatusOrderByValueDesc(int year, Status status);
}
