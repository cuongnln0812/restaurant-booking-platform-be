package com.foodbookingplatform.models.enums;

public enum OfferStatus {
    INACTIVE(0),
    ACTIVE(1),
    EXPIRE(2);
    private final int value;

    OfferStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
