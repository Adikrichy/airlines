package com.aldousdev.airlines.service;

public interface EmailService {
    void sendPasswordResetEmail(String toEmail, String token);
}
