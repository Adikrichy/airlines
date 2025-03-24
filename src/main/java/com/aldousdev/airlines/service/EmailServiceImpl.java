package com.aldousdev.airlines.service;

import com.aldousdev.airlines.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendPasswordResetEmail(String toEmail, String token) {
        String resetLink = "https://localhost:8080/reset-password?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Сброс пароля");
        message.setText("Для сброса пароля перейдите по ссылке: " + resetLink);
        message.setFrom("adil.erzhanoc.70@gmail.com"); // Здесь указывайте тот email, от которого отправляются сообщения
        mailSender.send(message);
        log.info("Password reset email sent to {}", toEmail);
    }
}
