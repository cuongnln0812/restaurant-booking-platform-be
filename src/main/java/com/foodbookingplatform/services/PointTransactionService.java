package com.foodbookingplatform.services;

import com.foodbookingplatform.models.entities.User;

public interface PointTransactionService {
    void addPointForBooking(User user, Integer numberOfPeople, Float totalAmount);
    void addPointForFeedback(User user);
}
