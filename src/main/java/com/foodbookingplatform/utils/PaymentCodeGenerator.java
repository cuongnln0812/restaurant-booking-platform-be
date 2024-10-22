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
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("ddMMyyyyHHmmss");

    public static String generateOrderCode(long userId) {
        Date now = new Date();
        String dateTime = DATE_TIME_FORMAT.format(now);
        return ORDER_PAYMENT_CODE + dateTime + userId;
    }

    public static String generateCommissionCode(long userId) {
        Date now = new Date();
        String dateTime = DATE_TIME_FORMAT.format(now);
        return COMMISSION_PAYMENT_CODE + dateTime + userId;
    }

    public static long getUserIdFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);

        // Length constants
        int paymentCodeLength = 3;      // Payment code (100 or 200)
        int dateTimeLength = 14;        // ddMMyyyyHHmmss

        // Calculate the starting index for userId
        int userIdStartIndex = paymentCodeLength + dateTimeLength;

        if (userIdStartIndex < orderCodeString.length()) {
            String userIdString = orderCodeString.substring(userIdStartIndex);
            return Long.parseLong(userIdString);
        } else {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Invalid order code: " + orderCode);
        }
    }

    public static int getMonthFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);

        // Position constants for month in ddMMyyyyHHmmss
        int paymentCodeLength = 3;
        int dayLength = 2;
        int monthStartIndex = paymentCodeLength + dayLength;
        int monthLength = 2;

        String monthString = orderCodeString.substring(monthStartIndex, monthStartIndex + monthLength);
        return Integer.parseInt(monthString);
    }

    public static int getYearFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);

        // Position constants for year in ddMMyyyyHHmmss
        int paymentCodeLength = 3;
        int dayLength = 2;
        int monthLength = 2;
        int yearStartIndex = paymentCodeLength + dayLength + monthLength;
        int yearLength = 4;

        String yearString = orderCodeString.substring(yearStartIndex, yearStartIndex + yearLength);
        return Integer.parseInt(yearString);
    }

    public static String getTimeFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);

        // Position constants for time in ddMMyyyyHHmmss
        int paymentCodeLength = 3;
        int dateLength = 8;  // ddMMyyyy
        int timeStartIndex = paymentCodeLength + dateLength;
        int timeLength = 6;  // HHmmss

        String timeString = orderCodeString.substring(timeStartIndex, timeStartIndex + timeLength);
        return formatTime(timeString);
    }

    public static String getDateTimeFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);

        int paymentCodeLength = 3;
        int dateTimeStartIndex = paymentCodeLength;
        int dateTimeLength = 14;  // ddMMyyyyHHmmss

        String dateTimeString = orderCodeString.substring(dateTimeStartIndex, dateTimeStartIndex + dateTimeLength);
        return formatDateTime(dateTimeString);
    }

    private static String formatTime(String timeString) {
        // Format HHmmss to HH:mm:ss
        return timeString.substring(0, 2) + ":" +
                timeString.substring(2, 4) + ":" +
                timeString.substring(4, 6);
    }

    private static String formatDateTime(String dateTimeString) {
        // Format ddMMyyyyHHmmss to dd-MM-yyyy HH:mm:ss
        return dateTimeString.substring(0, 2) + "-" +
                dateTimeString.substring(2, 4) + "-" +
                dateTimeString.substring(4, 8) + " " +
                dateTimeString.substring(8, 10) + ":" +
                dateTimeString.substring(10, 12) + ":" +
                dateTimeString.substring(12, 14);
    }

    public static String getPaymentCodeFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);
        int paymentCodeLength = 3;
        return orderCodeString.substring(0, paymentCodeLength);
    }
}