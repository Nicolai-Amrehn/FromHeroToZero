package com.nra.FromHeroToZero.domain;

import com.nra.FromHeroToZero.infrastructure.Status;
import jakarta.persistence.*;

@Entity
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    int value;
    Status status;
    int year;
    String reviewedBy;
    String submittedBy;
    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    public Measurement() {
    }

    public Measurement(int value, Status status, int year, String reviewedBy, String submittedBy, Country country) {
        this.value = value;
        this.status = status;
        this.year = year;
        this.reviewedBy = reviewedBy;
        this.submittedBy = submittedBy;
        this.country = country;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
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
                "value=" + value +
                ", status=" + status +
                ", year=" + year +
                ", reviewedBy='" + reviewedBy + '\'' +
                ", submittedBy='" + submittedBy + '\'' +
                ", country=" + country +
                '}';
    }
}
