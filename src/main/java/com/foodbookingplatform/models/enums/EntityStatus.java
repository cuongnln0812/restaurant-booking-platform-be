package com.foodbookingplatform.models.enums;

public enum EntityStatus {
    DISABLED(0),
    ACTIVE(1),
    INACTIVE(2);
    private final int value;

    EntityStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
