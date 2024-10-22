package com.foodbookingplatform.utils;

import com.foodbookingplatform.models.exception.RestaurantBookingException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class PaymentCodeGenerator {
    @Getter
    private static final String COMMISSION_PAYMENT_CODE = "200";
    @Getter
    private static final String ORDER_PAYMENT_CODE = "100";

    // Generate an order code with a UNIX timestamp for the current time (in seconds)
    public static String generateOrderCode(long userId) {
        long timestamp = Instant.now().getEpochSecond(); // Get current UNIX timestamp in seconds
        return ORDER_PAYMENT_CODE + timestamp + userId;
    }

    // Generate a commission code with a UNIX timestamp
    public static String generateCommissionCode(long userId) {
        long timestamp = Instant.now().getEpochSecond(); // Get current UNIX timestamp in seconds
        return COMMISSION_PAYMENT_CODE + timestamp + userId;
    }

    // Extract the userId from the order code
    public static long getUserIdFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);

        // Length constants
        int paymentCodeLength = 3;      // Payment code (100 or 200)
        int timestampLength = 10;       // UNIX timestamp in seconds

        // Calculate the starting index for userId
        int userIdStartIndex = paymentCodeLength + timestampLength;

        if (userIdStartIndex < orderCodeString.length()) {
            String userIdString = orderCodeString.substring(userIdStartIndex);
            return Long.parseLong(userIdString);
        } else {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "Invalid order code: " + orderCode);
        }
    }

    // Extract the payment code from the order code
    public static String getPaymentCodeFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);
        int paymentCodeLength = 3;
        return orderCodeString.substring(0, paymentCodeLength);
    }

    // Extract the UNIX timestamp from the order code
    public static long getTimestampFromOrderCode(long orderCode) {
        String orderCodeString = String.valueOf(orderCode);

        // Length constants
        int paymentCodeLength = 3;
        int timestampLength = 10;  // Length of the UNIX timestamp in seconds

        // Extract the timestamp substring
        int timestampStartIndex = paymentCodeLength;
        String timestampString = orderCodeString.substring(timestampStartIndex, timestampStartIndex + timestampLength);
        return Long.parseLong(timestampString);
    }

    // Convert timestamp to human-readable date and time
    public static String getDateTimeFromOrderCode(long orderCode) {
        long timestamp = getTimestampFromOrderCode(orderCode);
        Instant instant = Instant.ofEpochSecond(timestamp);
        return instant.toString(); // ISO-8601 format, e.g., 2024-10-22T10:15:30Z
    }

    public static int getMonthFromOrderCode(long orderCode) {
        long timestamp = getTimestampFromOrderCode(orderCode);
        // Set time zone to Asia/Ho_Chi_Minh
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("Asia/Ho_Chi_Minh"));
        return dateTime.getMonthValue(); // Returns month as an integer (1 for January, 12 for December)
    }

    public static int getYearFromOrderCode(long orderCode) {
        long timestamp = getTimestampFromOrderCode(orderCode);
        // Set time zone to Asia/Ho_Chi_Minh
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("Asia/Ho_Chi_Minh"));
        return dateTime.getYear(); // Returns the year
    }

    public static int getLastMonthFromOrderCode(long orderCode) {
        long timestamp = getTimestampFromOrderCode(orderCode);
        // Set time zone to Asia/Ho_Chi_Minh and adjust to the last month
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("Asia/Ho_Chi_Minh"));
        LocalDateTime lastMonthDateTime = dateTime.minusMonths(1); // Move to the previous month
        return lastMonthDateTime.getMonthValue(); // Returns month as an integer (1 for January, 12 for December)
    }

    // Extract the year from the previous month's timestamp in the Asia/Ho_Chi_Minh time zone
    public static int getLastYearFromOrderCode(long orderCode) {
        long timestamp = getTimestampFromOrderCode(orderCode);
        // Set time zone to Asia/Ho_Chi_Minh and adjust to the last month
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.of("Asia/Ho_Chi_Minh"));
        LocalDateTime lastMonthDateTime = dateTime.minusMonths(1); // Move to the previous month
        return lastMonthDateTime.getYear(); // Returns the year
    }

}
