package com.project.orders_service.feignClient;

import com.project.orders_service.dto.OrderLineDto;
import com.project.orders_service.feingClientReturn.ResponseFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "products-service", fallbackFactory = FallBackFactoryProduct.class)
public interface OrderProductFeignClient {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/graphql",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseFeign checkProductInStock(@RequestBody String query);


    @RequestMapping(
            method = RequestMethod.POST,
            value = "/graphql",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    void decrementQuantityOfProduct(@RequestBody String query);


}
