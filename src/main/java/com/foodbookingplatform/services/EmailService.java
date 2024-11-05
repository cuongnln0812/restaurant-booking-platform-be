package com.foodbookingplatform.services;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(String to, String subject, String content);
    void sendEmailWithQR(String to, String subject, String content, byte[] qrCodeImage);
}
