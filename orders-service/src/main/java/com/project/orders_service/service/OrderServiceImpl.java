package com.project.orders_service.service;

import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.entity.Order;
import com.project.orders_service.feignClient.OrderProduct;
import com.project.orders_service.mapper.OrderMapper;
import com.project.orders_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderProduct orderProduct;


    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order= orderMapper.orderDtoToOrder(orderDto);


        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public OrderDto getOrderById(String idOrder) {
        return null;
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public String deleteOrder(String idOrder) {
        return null;
    }

    @Override
    public Boolean test(List<OrderLineDto> orderLineDtos) {
        return orderProduct.checkProductInStock(orderLineDtos);

    }
}
