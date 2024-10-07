package com.project.orders_service.controller;

import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.dto.UserDto;
import com.project.orders_service.feignClient.OrderProduct;
import com.project.orders_service.feignClient.OrderUser;
import com.project.orders_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderUser orderUserService;
    private final OrderService orderService;


    @GetMapping("/{idUser}")
    public ResponseEntity<UserDto> test(@PathVariable String idUser) {
        return orderUserService.getUserById(idUser);
    }

    @PostMapping
    public boolean test(@RequestBody List<OrderLineDto> orderLineDtoList) {
        return orderService.test(orderLineDtoList);
    }
}
