package ru.netology.service.bff.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.netology.order.dto.OrderDto;
import ru.netology.service.bff.dto.UserProfileDto;
import ru.netology.user.dto.UserDto;

import java.util.List;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {
    private final WebClient webClient;

    public BffController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserProfileDto> getUserProfile(@PathVariable("userId") Long userId) {
        Mono<UserDto> userMono = webClient.get()
                .uri("http://localhost:8081/api/users/{userId}", userId)
                .retrieve()
                .bodyToMono(UserDto.class);

        Mono<List<OrderDto>> ordersMono = webClient.get()
                .uri("http://localhost:8082/api/orders/by-user/{userId}", userId)
                .retrieve()
                .bodyToFlux(OrderDto.class)
                .collectList();

        UserProfileDto profile = Mono.zip(userMono, ordersMono, UserProfileDto::new).block();
        return ResponseEntity.ok(profile);
    }
}
