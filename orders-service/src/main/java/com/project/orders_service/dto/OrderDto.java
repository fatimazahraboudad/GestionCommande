package com.project.orders_service.dto;

import com.project.orders_service.entity.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDto {

    private String idOrder;
    private List<OrderLineDto> ordersLine;
    private UserDto userDto;

}
