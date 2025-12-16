package ru.netology.user.order.repository;

import org.springframework.stereotype.Repository;
import ru.netology.order.dto.OrderDto;
import ru.netology.order.dto.OrderItemDto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<Long, List<OrderDto>> ordersByUser = new HashMap<>();

    public OrderRepository() {
        List<OrderItemDto> items1 = List.of(
                new OrderItemDto("Товар A", 1, 50.0),
                new OrderItemDto("Товар B", 2, 25.0)
        );
        List<OrderItemDto> items2 = List.of(
                new OrderItemDto("Товар C", 1, 50.0)
        );
        ordersByUser.put(1L, List.of(
                new OrderDto(1L, 1L, 100.0, "RUB", items1),
                new OrderDto(2L, 1L, 50.0, "RUB", items2)
        ));

        List<OrderItemDto> items3 = List.of(
                new OrderItemDto("Товар D", 1, 120.0),
                new OrderItemDto("Товар E", 2, 40.0)
        );
        ordersByUser.put(2L, List.of(
                new OrderDto(3L, 2L, 200.0, "RUB", items3)
        ));
    }

    public List<OrderDto> findByUserId(Long userId) {
        return ordersByUser.getOrDefault(userId, Collections.emptyList());
    }
}
