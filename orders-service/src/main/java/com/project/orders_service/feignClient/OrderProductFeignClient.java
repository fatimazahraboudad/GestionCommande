package com.project.orders_service.feignClient;

import com.project.orders_service.dto.OrderLineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "products-service")
public interface OrderProductFeignClient {



    @PostMapping()
    public boolean checkProductInStock(@RequestBody List<OrderLineDto> orderLineDtos);


    @PutMapping()
    public String decrementQuantityOfProduct(@RequestBody List<OrderLineDto> orderLineDtos);

}
