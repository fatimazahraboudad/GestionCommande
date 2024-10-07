package com.project.orders_service.mapper;

import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = OrderLineMapper.class)
public interface OrderMapper {


    Order orderDtoToOrder(OrderDto orderDto);
    OrderDto orderToOrderDto(Order order);
}
