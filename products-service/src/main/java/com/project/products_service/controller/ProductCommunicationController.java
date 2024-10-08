package com.project.products_service.controller;

import com.project.products_service.dto.OrderLineDto;
import com.project.products_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCommunicationController {


    private final ProductService productService;

    @PostMapping
    public boolean checkProductInStock(@RequestBody List<OrderLineDto> orderLineDtos) {
        return productService.checkProductInStock(orderLineDtos);
    }

    @PutMapping
    public String decrementQuantityOfProduct(@RequestBody List<OrderLineDto> orderLineDto) {
        return productService.decrementQuantityOfProduct(orderLineDto);
    }
}
