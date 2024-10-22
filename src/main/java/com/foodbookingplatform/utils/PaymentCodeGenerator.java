package com.foodbookingplatform.utils;

import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.repositories.MonthlyCommissionPaymentRepository;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentCodeGenerator {
    @Getter
    private static final String COMMISSION_PAYMENT_CODE = "200";
    @Getter
    private static final String ORDER_PAYMENT_CODE = "100";

    public static String generateOrderCode(long userId) {
        Date now = new Date();

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String day = dayFormat.format(now);
        String month = monthFormat.format(now);
        String year = yearFormat.format(now);

        return ORDER_PAYMENT_CODE + day + month + year + userId;
    }

    public static String generateCommissionCode(long userId) {
        Date now = new Date();

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        String day = dayFormat.format(now);
        String month = monthFormat.format(now);
        String year = yearFormat.format(now);

        return COMMISSION_PAYMENT_CODE + day + month + year + userId;
    }

    public static long getUserIdFromOrderCode(long orderCode) {
        // Convert the long orderCode to a string for manipulation
        String orderCodeString = String.valueOf(orderCode);

        // Assuming the fixed lengths of the payment code (3) and date components (2 + 2 + 4)
        int paymentCodeLength = 3; // Length of COMMISSION_PAYMENT_CODE or ORDER_PAYMENT_CODE
        int dayLength = 2;          // Length of day
        int monthLength = 2;        // Length of month
        int yearLength = 4;         // Length of year

        // Calculate the starting index for userId extraction
        int userIdStartIndex = paymentCodeLength + dayLength + monthLength + yearLength;

        // Check if orderCodeString is long enough to extract userId
        if (userIdStartIndex < orderCodeString.length()) {
            // Extract the userId part from the order code
            String userIdString = orderCodeString.substring(userIdStartIndex);
            return Long.parseLong(userIdString);
        } else {
            // Handle cases where the order code does not have a valid userId
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Invalid order code: " + orderCode);
        }
    }

    public static int getMonthFromOrderCode(long orderCode) {
        // Convert the long orderCode to a string for manipulation
        String orderCodeString = String.valueOf(orderCode);

        // Assuming the fixed lengths of the payment code (3) and date components (2 + 2 + 4)
        int paymentCodeLength = 3; // Length of COMMISSION_PAYMENT_CODE or ORDER_PAYMENT_CODE
        int dayLength = 2;          // Length of day
        int monthLength = 2;        // Length of month

        // Extract month from the order code
        String monthString = orderCodeString.substring(paymentCodeLength + dayLength, paymentCodeLength + dayLength + monthLength);
        return Integer.parseInt(monthString);
    }

    public static int getYearFromOrderCode(long orderCode) {
        // Convert the long orderCode to a string for manipulation
        String orderCodeString = String.valueOf(orderCode);

        // Assuming the fixed lengths of the payment code (3) and date components (2 + 2 + 4)
        int paymentCodeLength = 3; // Length of COMMISSION_PAYMENT_CODE or ORDER_PAYMENT_CODE
        int dayLength = 2;          // Length of day
        int monthLength = 2;        // Length of month
        int yearLength = 4;         // Length of year

        // Extract year from the order code
        String yearString = orderCodeString.substring(paymentCodeLength + dayLength + monthLength + dayLength, paymentCodeLength + dayLength + monthLength + yearLength);
        return Integer.parseInt(yearString);
    }

    public static String getPaymentCodeFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);
        int paymentCodeLength = 3;

        // Ensure the orderCodeString is long enough to extract the payment code
        return orderCodeString.substring(0, paymentCodeLength);
    }

}