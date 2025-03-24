package com.aldousdev.airlines.service;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oauth2User = super.loadUser(userRequest);
        // Здесь можно добавить логику для маппинга атрибутов OAuth2User
        // Например, извлечь email, имя и т.д. и создать/обновить локального пользователя
        // Пример:
        // String email = oauth2User.getAttribute("email");
        // if (userNotFound(email)) { createUser(email, ...); }
        return oauth2User;
    }
}
