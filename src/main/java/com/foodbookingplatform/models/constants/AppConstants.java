package com.foodbookingplatform.models.constants;

public class AppConstants {
    public static final String DEFAULT_PAGE_NUMBER = "0";

    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    public static final String DEFAULT_SORT_BY= "id";
    public static final String DEFAULT_BOOKING_STATUS= "SUCCESSFUL";
    public static final String EMAIL_REGEX = "^[^\\.][a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$";
    public static final String PHONE_REGEX = "(84|0[35789])([0-9]{8})\\b";
    public static final String VOUCHER_CODE_REGEX = "^KK[a-zA-Z0-9]{5}$";
    public static final String GENDER_REGEX = "^(Male|Female|Other)$";
    public static final String RECIPIENT_TYPE_REGEX = "^(USER|LOCATION)$";
    public static final String NOTIFICATION_TYPE_REGEX = "^(ORDER|PROMOTION|OTHER)$";
    public static final String ADS_TYPE_REGEX = "^(AREA|FLASH_SALE|BANNER)$";
    public static final String PROMOTION_TYPE_REGEX = "^(BILL|PEOPLE|TIME)$";
    public static final String ROLE_LOCATION = "LOCATION_ADMIN";
    public static final String ROLE_USER = "USER";
    public static final String ROLE_SYSTEM = "SYSTEM_ADMIN";
    public static final String NUMBER_OF_GUEST = "0";

    // fee
    public static final double CHARGE_FEE_PER_BOOKING = 10000;
    public static final double SUBSCRIPTION_FEE_PER_MONTH = 300000;
}
