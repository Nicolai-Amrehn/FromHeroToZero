package com.nra.FromHeroToZero.infrastructure;

public enum Status {
    APPROVED("Approved"),
    REJECTED("Rejected"),
    PROPOSED("Proposed");

    private final String status;
    Status(String status) {this.status = status;}
}
