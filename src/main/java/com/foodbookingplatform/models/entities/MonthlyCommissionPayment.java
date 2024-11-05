package com.foodbookingplatform.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "monthly_commission_payments")
public class MonthlyCommissionPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private int month;
    private int year;
    private int fixedAmount;
    private float totalAmount;
    private int totalBooking;
    private boolean isPaid;
    private String paidAt;
    private LocalDateTime expiredAt;
    private Long transactionId;
}

