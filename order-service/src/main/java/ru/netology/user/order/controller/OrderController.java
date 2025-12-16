package ru.netology.user.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.order.dto.OrderDto;
import ru.netology.user.order.repository.OrderRepository;

import java.util.List;

@RestController
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/orders/by-user/{userId}")
    public List<OrderDto> getOrders(@PathVariable("userId") Long userId) {
        return repository.findByUserId(userId);
    }
}
