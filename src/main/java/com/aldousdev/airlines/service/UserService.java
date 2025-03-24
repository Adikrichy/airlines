package com.aldousdev.airlines.service;

import com.aldousdev.airlines.dto.TwoFactorAuthResponseDTO;
import com.aldousdev.airlines.dto.UserProfileDTO;
import com.aldousdev.airlines.entity.PasswordResetToken;
import com.aldousdev.airlines.entity.User;
import com.aldousdev.airlines.repository.PasswordResetTokenRepository;
import com.aldousdev.airlines.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordResetTokenRepository tokenRepository;
    private final EmailService emailService;

    // Получение профиля пользователя по email
    public UserProfileDTO getProfile(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserProfileDTO dto = new UserProfileDTO();
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }

    // Обновление профиля пользователя
    public UserProfileDTO updateProfile(String email, UserProfileDTO profileDTO) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(profileDTO.getFirstName());
        user.setLastName(profileDTO.getLastName());
        userRepository.save(user);
        return profileDTO;
    }

    // Инициация сброса пароля
    public void initiatePasswordReset(String email) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            String token = UUID.randomUUID().toString();
            LocalDateTime expiryDate = LocalDateTime.now().plusHours(24);
            PasswordResetToken resetToken = new PasswordResetToken(null, token, user, expiryDate);
            tokenRepository.save(resetToken);
            emailService.sendPasswordResetEmail(email, token);
        }
        // Для безопасности, если пользователь не найден, можно не сообщать об этом клиенту.
    }

    // Сброс пароля по токену
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Invalid token"));
        if (resetToken.isExpired()) {
            throw new RuntimeException("Token has expired");
        }
        User user = resetToken.getUser();
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        tokenRepository.delete(resetToken);
    }

    // (Опционально) Включение двухфакторной аутентификации
    public TwoFactorAuthResponseDTO enableTwoFactorAuth(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        String secret = generateSecretForUser(user);
        String qrCodeUrl = generateQRCodeUrl(user.getEmail(), secret);
        user.setTwoFactorSecret(secret);
        userRepository.save(user);
        return new TwoFactorAuthResponseDTO(secret, qrCodeUrl);
    }

    // Заглушки для генерации секрета и QR-кода. Реальную реализацию можно сделать с помощью библиотеки TOTP.
    private String generateSecretForUser(User user) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    private String generateQRCodeUrl(String email, String secret) {
        String issuer = "AirlinesApp";
        return "otpauth://totp/" + issuer + ":" + email + "?secret=" + secret + "&issuer=" + issuer;
    }

    // Допустим, добавим метод проверки кода двухфакторной аутентификации в UserService
    public boolean verifyTwoFactorCode(String email, String code) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Реальная проверка кода зависит от выбранной библиотеки
        // Ниже пример для псевдокода:
        // return TOTPVerifier.verify(user.getTwoFactorSecret(), code);
        return true; // Заглушка для примера
    }

}
