package com.aldousdev.airlines.repository;

import com.aldousdev.airlines.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Поиск пользователя по email (уникальное поле)
    Optional<User> findByEmail(String email);

    // Проверка существования пользователя по email
    boolean existsByEmail(String email);

    // Поиск пользователей по роли
    List<User> findByRole(Role role);
}
