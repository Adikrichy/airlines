package com.aldousdev.airlines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuth2SuccessController {

    @GetMapping("/oauth2/success")
    public String oauth2Success() {
        // Можно перенаправить на главную страницу или профиль пользователя
        return "redirect:/profile";
    }
}
