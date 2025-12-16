package ru.netology.user.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.user.dto.UserDto;
import ru.netology.user.service.repository.UserRepository;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;

    @GetMapping("/api/users/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
