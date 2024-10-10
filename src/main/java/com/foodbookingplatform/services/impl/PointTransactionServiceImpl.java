package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.repositories.PointTransactionRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.PointTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PointTransactionServiceImpl implements PointTransactionService {

    private final PointTransactionRepository pointTransactionRepository;
    private final UserRepository userRepository;


    @Override
    public void addPointForBooking(User user, Integer numberOfPeople, Float totalAmount) {
    }

    @Override
    public void addPointForFeedback(User user) {

    }

    private Integer addPointForTotalPeople(Integer numberOfPeople){
        return numberOfPeople * 10;
    }

    private Integer addPointForTotalAmount(Float totalAmount){
        return (int) (totalAmount / 1000);
    }
}
