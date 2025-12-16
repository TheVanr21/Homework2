package ru.netology.user.service.repository;

import org.springframework.stereotype.Repository;
import ru.netology.user.dto.UserDto;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Long, UserDto> users = new HashMap<>();

    public UserRepository() {
        users.put(1L, new UserDto(1L, "Иван Иванов", "Москва, ул. Ленина, 1", "+79161234567", "ivan@mail.ru"));
        users.put(2L, new UserDto(2L, "Петр Петров", "Санкт-Петербург, Невский пр., 10", "+79211234567", "petr@mail.ru"));
    }

    public UserDto findById(Long userId) {
        return users.get(userId);
    }
}
