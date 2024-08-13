package com.foodbookingplatform.models.enums;

public enum LocationBookingStatus {
    FAILED(0),
    PENDING(1),
    CONFIRMED(2),
    CANCELLED(3),
    SUCCESSFUL(4);
    private final int value;

    LocationBookingStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
