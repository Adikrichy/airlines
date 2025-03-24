package com.aldousdev.airlines.controller;

import com.aldousdev.airlines.dto.PasswordResetDTO;
import com.aldousdev.airlines.dto.PasswordResetRequestDTO;
import com.aldousdev.airlines.dto.TwoFactorAuthResponseDTO;
import com.aldousdev.airlines.dto.UserProfileDTO;
import com.aldousdev.airlines.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Получение профиля текущего пользователя
    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> getProfile(Authentication authentication) {
        String email = authentication.getName();
        UserProfileDTO profile = userService.getProfile(email);
        return ResponseEntity.ok(profile);
    }

    // Обновление профиля
    @PutMapping("/profile")
    public ResponseEntity<UserProfileDTO> updateProfile(@Valid @RequestBody UserProfileDTO profileDTO,
                                                        Authentication authentication) {
        String email = authentication.getName();
        UserProfileDTO updatedProfile = userService.updateProfile(email, profileDTO);
        return ResponseEntity.ok(updatedProfile);
    }

    // Запрос на восстановление пароля
    @PostMapping("/password-reset/request")
    public ResponseEntity<String> requestPasswordReset(@Valid @RequestBody PasswordResetRequestDTO requestDTO) {
        userService.initiatePasswordReset(requestDTO.getEmail());
        return ResponseEntity.ok("Если указанный email существует, ссылка для сброса пароля отправлена.");
    }

    // Подтверждение сброса пароля
    @PostMapping("/password-reset/confirm")
    public ResponseEntity<String> resetPassword(@Valid @RequestBody PasswordResetDTO resetDTO) {
        userService.resetPassword(resetDTO.getToken(), resetDTO.getNewPassword());
        return ResponseEntity.ok("Пароль успешно обновлён.");
    }

    // (Опционально) Включение двухфакторной аутентификации
    @PostMapping("/2fa/enable")
    public ResponseEntity<TwoFactorAuthResponseDTO> enableTwoFactorAuth(Authentication authentication) {
        String email = authentication.getName();
        TwoFactorAuthResponseDTO response = userService.enableTwoFactorAuth(email);
        return ResponseEntity.ok(response);
    }
}
