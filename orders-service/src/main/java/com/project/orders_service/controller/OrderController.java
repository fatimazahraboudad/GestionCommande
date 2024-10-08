package com.project.orders_service.controller;

import com.project.orders_service.dto.OrderDto;
import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.dto.UserDto;
import com.project.orders_service.feignClient.OrderUserFeignClient;
import com.project.orders_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderUserFeignClient orderUserFeignClientService;
    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
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
