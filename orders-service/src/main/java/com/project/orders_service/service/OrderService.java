package com.project.orders_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.dto.OrderLineDto;

import java.util.List;

public interface OrderService {

    OrderDto addOrder(OrderDto orderDto) throws JsonProcessingException;
    List<OrderDto> getAllOrders();

    OrderDto getOrderById(String idOrder);

    OrderDto updateOrder(OrderDto orderDto);

    String deleteOrder(String idOrder);


}
