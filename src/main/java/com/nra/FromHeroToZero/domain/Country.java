package com.nra.FromHeroToZero.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "country")
    private List<Measurement> measurements;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, List<Measurement> measurements) {
        this.name = name;
        this.measurements = measurements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", measurements=" + measurements +
                '}';
    }
}
