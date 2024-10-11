package com.project.orders_service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.dto.UserDto;
import com.project.orders_service.feignClient.OrderUserFeignClient;
import com.project.orders_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderUserFeignClient orderUserFeignClientService;
    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) throws JsonProcessingException {
        return new ResponseEntity<>(orderService.addOrder(orderDto), HttpStatus.CREATED);


    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String idOrder) {
        return new ResponseEntity<>(orderService.getOrderById(idOrder), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PutMapping("/{idOrder}")
    public ResponseEntity<String> deleteOrder(@PathVariable String idOrder) {
        return new ResponseEntity<>(orderService.deleteOrder(idOrder), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<OrderDto> deleteOrder(@RequestBody OrderDto orderDto) {
        return new ResponseEntity<>(orderService.updateOrder(orderDto), HttpStatus.OK);
    }







}
