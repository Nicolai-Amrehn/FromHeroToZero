package com.nra.FromHeroToZero.domain;

import com.nra.FromHeroToZero.infrastructure.Status;
import jakarta.persistence.*;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Double value;
    Status status;
    int year;
    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    public Measurement() {
    }

    public Measurement(Double value, Status status, int year, Country country) {
        this.value = value;
        this.status = status;
        this.year = year;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", value=" + value +
                ", status=" + status +
                ", year=" + year +
                ", country=" + country +
                '}';
    }
}
