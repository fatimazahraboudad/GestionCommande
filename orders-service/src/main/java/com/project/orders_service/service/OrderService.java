package com.project.orders_service.service;

import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.dto.OrderLineDto;

import java.util.List;

public interface OrderService {

    OrderDto addOrder(OrderDto orderDto);
    List<OrderDto> getAllOrders();

    OrderDto getOrderById(String idOrder);

    OrderDto updateOrder(OrderDto orderDto);

    String deleteOrder(String idOrder);

    Boolean test(List<OrderLineDto> orderLineDto);

}
