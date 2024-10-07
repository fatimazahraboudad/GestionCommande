package com.project.orders_service.feignClient;

import com.project.orders_service.dto.OrderLineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "products-service")
public interface OrderProduct {



    @PostMapping()
    public boolean checkProductInStock(@RequestBody List<OrderLineDto> orderLineDtos);

}
