package ru.netology.service.bff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.netology.order.dto.OrderDto;
import ru.netology.user.dto.UserDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
    private UserDto user;
    private List<OrderDto> orders;
}
