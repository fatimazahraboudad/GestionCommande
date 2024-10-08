package com.project.orders_service.mapper;

import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = OrderLineMapper.class)
public interface OrderMapper {

    Order OrderDtoToOrder(OrderDto orderDto);
    OrderDto OrderToOrderDto(Order order);
    List<Order> OrderDtoToOrder(List<OrderDto> orderDto);
    List<OrderDto> OrderToOrderDto(List<Order> order);
}
