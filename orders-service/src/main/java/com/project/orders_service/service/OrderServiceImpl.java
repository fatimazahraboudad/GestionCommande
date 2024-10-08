package com.project.orders_service.service;

import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.entity.Order;
import com.project.orders_service.exception.OrderNotExistException;
import com.project.orders_service.exception.ProductNotExistInStock;
import com.project.orders_service.exception.ProductQuantityVerification;
import com.project.orders_service.feignClient.OrderProductFeignClient;
import com.project.orders_service.feignClient.OrderUserFeignClient;
import com.project.orders_service.mapper.OrderLineMapper;
import com.project.orders_service.mapper.OrderMapper;
import com.project.orders_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderProductFeignClient orderProductFeignClient;
    private final OrderUserFeignClient orderUserFeignClient;


    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        orderDto.getOrdersLine().forEach(
                orderLineDto ->{
                    if (orderLineDto.getQuantity() <= 0) {
                        throw new ProductQuantityVerification(orderLineDto.getIdProduct());
                    }
                }

        );

        if(!orderProductFeignClient.checkProductInStock(orderDto.getOrdersLine())){
            throw new ProductNotExistInStock();
        }
        Order order= orderMapper.OrderDtoToOrder(orderDto);
        order.setIdOrder(UUID.randomUUID().toString());
        order.getOrdersLine().forEach(orl -> {
                orl.setOrder(order);
                orl.setIdOrderLine(UUID.randomUUID().toString());});
        order.setIdUser(orderDto.getUserDto().getIdUser());
        order.setDeleted(false);

        orderProductFeignClient.decrementQuantityOfProduct(orderDto.getOrdersLine());
        return orderMapper.OrderToOrderDto(orderRepository.save(order));
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return  orderRepository.findAll().stream().filter(
                order -> !order.isDeleted()
        ).map(
                order -> {
                    return getOrderDto(order.getIdOrder());
                }
        ).toList();

    }

    @Override
    public OrderDto getOrderById(String idOrder) {
        return getOrderDto(idOrder);

    }

    private OrderDto getOrderDto(String idOrder) {
        OrderDto orderDto = orderMapper.OrderToOrderDto(helper(idOrder));
        orderDto.setUserDto(orderUserFeignClient.getUserById(helper(idOrder).getIdUser()).getBody());
        return orderDto;
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {
        Order order= helper(orderDto.getIdOrder());
        order.setOrdersLine(OrderLineMapper.mapper.OrderLineDtoToOrderLine(orderDto.getOrdersLine()));
        order.getOrdersLine().forEach(orderLine ->
                orderLine.setOrder(order));

        return orderMapper.OrderToOrderDto(orderRepository.save(order));
    }




    @Override
    public String deleteOrder(String idOrder) {
        Order order = helper(idOrder);
        order.setDeleted(true);
        orderRepository.save(order);
        return "order deleted";
    }



    public Order helper(String idOrder) {
        return orderRepository.findById(idOrder).filter(order -> !order.isDeleted()).orElseThrow(()->new OrderNotExistException(idOrder));


    }


    }
